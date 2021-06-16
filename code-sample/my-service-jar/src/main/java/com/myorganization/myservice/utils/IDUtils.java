package com.myorganization.myservice.utils;

import com.myorganization.myservice.exception.IdValidationException;

public class IDUtils {

    private static final String NA = "NA";
    private static final String LEGAL_PERSON_STARTING_CHARS = "ABCDEFGHJKLMNPQRSUVW";
    private static final String FOREIGN_PERSON_STARTING_CHARS = "XYZ";
    private static final String LEGAL_PERSON_USES_CONTROL_CHAR = "KPQS";
    private static final String LEGAL_PERSON_USES_CONTROL_DIGIT = "ABEH";
    private static final String EXPECTED_CONTROL_CHARS = "JABCDEFGHI";
    private static final String EXPECTED_CONTROL_DIGIT_CHARS = "TRWAGMYFPDXBNJZSQVHLCKE";

    public static final String PHYSICAL_PERSON_ID = "DNI";
    public static final String FOREIGN_PERSON_ID = "NIE";
    public static final String LEGAL_PERSON_ID = "CIF";
    public static final String PASSPORT = "PASS";
    public static final String UNKNOWN_TYPE = "Unknown ID type";
    public static final String ID_NOT_SUPPORTED = "ID not supported";
    public static final String ID_NOT_FOUND = "ID not found";
    public static final String IDVALID_LENGHT = ": invalid length";
    public static final String IDVALID_CNTRL_DIGIT = ": invalid control digit";
    public static final String IDVALID_FORMAT = ": invalid format";

    private IDUtils() {
        throw new IllegalStateException("Cannot instantiate IDUtils");
    }

    public static String determineAndValidateSpainIdType(String idCode, String idType) throws IdValidationException {
    	if (idCode== null || idCode.length()<1) {
            throw new IdValidationException(ID_NOT_FOUND);
    	}
    	
        String startsWith = idCode.substring(0,  1);
        String result = determineIdType(idCode, idType, startsWith);

        // validation stage
        switch (result) {
        case LEGAL_PERSON_ID:
            validateLegalPerson(idCode, startsWith);
            return LEGAL_PERSON_ID;
        case FOREIGN_PERSON_ID:
            int foreignLetter = FOREIGN_PERSON_STARTING_CHARS.indexOf(startsWith);
            idCode = foreignLetter + idCode.substring(1);
            validatePhysicalPerson(idCode, FOREIGN_PERSON_ID);
            return FOREIGN_PERSON_ID;
        case PHYSICAL_PERSON_ID:
            validatePhysicalPerson(idCode, PHYSICAL_PERSON_ID);
            return PHYSICAL_PERSON_ID;
        case PASSPORT:
            return PASSPORT;
        case NA:
            return NA;
        default:
            throw new IdValidationException(UNKNOWN_TYPE);
        }
    }

    private static void validatePhysicalPerson(String idCode, String personTyle) throws IdValidationException {
        try {
            int idNumber = Integer.parseInt(idCode.substring(0, idCode.length()-1));
            idNumber = idNumber%23;

            String expectedControlDigit = Character.toString(EXPECTED_CONTROL_DIGIT_CHARS.charAt(idNumber));

            if (!idCode.endsWith(expectedControlDigit)) {
                throw new IdValidationException(personTyle + IDVALID_CNTRL_DIGIT);
            }
        }
        catch (NumberFormatException e) {
            throw new IdValidationException(personTyle + IDVALID_FORMAT);
        }
    }

    private static void validateLegalPerson(String idCode, String startsWith) throws IdValidationException {
        if (idCode.length() != 9) {
            throw new IdValidationException(LEGAL_PERSON_ID + IDVALID_LENGHT);
        }

        int c;
        int d;
        try {
            int even = Integer.parseInt(idCode.substring(6, 7)) + Integer.parseInt(idCode.substring(4, 5)) + Integer.parseInt(idCode.substring(2, 3));
            int odd4 = sumDigits(Integer.parseInt(idCode.substring(7, 8))*2);
            int odd3 = sumDigits(Integer.parseInt(idCode.substring(5, 6))*2);
            int odd2 = sumDigits(Integer.parseInt(idCode.substring(3, 4))*2);
            int odd1 = sumDigits(Integer.parseInt(idCode.substring(1, 2))*2);
            int impar = odd4 + odd3 + odd2 + odd1 ;
            c = (even + impar) % 10;
            d = c == 0 ? 0 : 10 - c;
        } catch (NumberFormatException e) {
            throw new IdValidationException(LEGAL_PERSON_ID + IDVALID_FORMAT);
        }

        String expectedControlDigit = Integer.toString(d);
        String expectedControlChar = String.valueOf(EXPECTED_CONTROL_CHARS.charAt(d));

        if (LEGAL_PERSON_USES_CONTROL_CHAR.contains(startsWith)) {
            if (!idCode.endsWith(expectedControlChar)) {
                throw new IdValidationException(LEGAL_PERSON_ID + IDVALID_CNTRL_DIGIT);
            }
        } else if (LEGAL_PERSON_USES_CONTROL_DIGIT.contains(startsWith)) {
            if(!idCode.endsWith(expectedControlDigit)) {
                throw new IdValidationException(LEGAL_PERSON_ID + IDVALID_CNTRL_DIGIT);
            }
        } else {
            if (!idCode.endsWith(expectedControlDigit) && !idCode.endsWith(expectedControlChar)) {
                throw new IdValidationException(LEGAL_PERSON_ID + IDVALID_CNTRL_DIGIT);
            }
        }
    }

    private static String determineIdType(String idCode, String idType, String startsWith) throws IdValidationException {
        if(NA.equals(idType)) {
            return NA;
        } else if (PASSPORT.equals(idType)) {
            return PASSPORT;
        } else if ("ID".equals(idType) && idCode!=null && idCode.length() > 0) {
            if (LEGAL_PERSON_STARTING_CHARS.contains(startsWith)) {
                return LEGAL_PERSON_ID;
            } else if (FOREIGN_PERSON_STARTING_CHARS.contains(startsWith)) {
                return FOREIGN_PERSON_ID;
            } else {
                return PHYSICAL_PERSON_ID;
            }
        }

        throw new IdValidationException(UNKNOWN_TYPE);
    }

    private static int sumDigits(int number) {

        int accumulated = 0;

        for (int i=0; i<String.valueOf(number).length(); i++) 
            accumulated = accumulated + Integer.parseInt(String.valueOf(number).substring(i, i+1));

        return accumulated;

    }

}
