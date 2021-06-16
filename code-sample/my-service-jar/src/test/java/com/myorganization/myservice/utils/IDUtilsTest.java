package com.myorganization.myservice.utils;

import com.myorganization.myservice.exception.IdValidationException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class IDUtilsTest {

    @Test
    public void testDetermineAndValidateSpainIdTypeWrongType() {
        String idCode = "123456789";
        String idType = "WRONG";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            fail("should throw IDValidationException");
        } catch (IdValidationException e) {
            // expected behaviour
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePassport() {
        String idCode = "123456789";
        String idType = "PASS";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("PASS", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeLegalPersonOk() {
        String idCode = "A10000008";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("CIF", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeLegalPersonKoLength() {
        String idCode = "A100";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            fail("should throw IDValidationException");
        } catch (IdValidationException e) {
            // expected behaviour
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeLegalPersonKo1() {
        String idCode = "E10000018";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            fail("should throw IDValidationException");
        } catch (IdValidationException e) {
            // expected behaviour
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeLegalPersonKo2() {
        String idCode = "H10000028";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            fail("should throw IDValidationException");
        } catch (IdValidationException e) {
            // expected behaviour
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeLegalPersonKo3() {
        String idCode = "A10000038";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            fail("should throw IDValidationException");
        } catch (IdValidationException e) {
            // expected behaviour
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeLegalPersonKo4() {
        String idCode = "B10000048";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            fail("should throw IDValidationException");
        } catch (IdValidationException e) {
            // expected behaviour
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeLegalPersonKo5() {
        String idCode = "E10000058";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            fail("should throw IDValidationException");
        } catch (IdValidationException e) {
            // expected behaviour
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeLegalPersonKo6() {
        String idCode = "H10000068";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            fail("should throw IDValidationException");
        } catch (IdValidationException e) {
            // expected behaviour
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeLegalPersonKo7() {
        String idCode = "A10000078";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            fail("should throw IDValidationException");
        } catch (IdValidationException e) {
            // expected behaviour
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeLegalPersonKo8() {
        String idCode = "B10000088";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            fail("should throw IDValidationException");
        } catch (IdValidationException e) {
            // expected behaviour
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeLegalPersonKo9() {
        String idCode = "B10000098";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            fail("should throw IDValidationException");
        } catch (IdValidationException e) {
            // expected behaviour
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeLegalPersonPOk() {
        String idCode = "P1000000H";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("CIF", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeLegalPersonKOk() {
        String idCode = "K1000000H";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("CIF", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeLegalPersonQOk() {
        String idCode = "Q1000000H";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("CIF", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeLegalPersonSOk() {
        String idCode = "S1000000H";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("CIF", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeLegalPersonSKo() {
        String idCode = "S1000000I";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            fail("should throw IDValidationException");
        } catch (IdValidationException e) {
            // expected behaviour
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeLegalPersonAnotherOk1() {
        String idCode = "C1000000H";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("CIF", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeLegalPersonAnotherOk2() {
        String idCode = "C10000008";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("CIF", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeLegalPersonAnotherKo() {
        String idCode = "C10000009";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            fail("should throw IDValidationException");
        } catch (IdValidationException e) {
            // expected behaviour
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeLegalPersonWrongFormat() {
        String idCode = "C1000A008";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            fail("should throw IDValidationException");
        } catch (IdValidationException e) {
            // expected behaviour
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeForeignPersonOkX() {
        String idCode = "X100P";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("NIE", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeForeignPersonOkY() {
        String idCode = "Y100L";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("NIE", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeForeignPersonOkZ() {
        String idCode = "Z100F";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("NIE", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeForeignPersonKo() {
        String idCode = "X100R";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            fail("should throw IDValidationException");
        } catch (IdValidationException e) {
            // expected behaviour
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk0() {
        String idCode = "0T";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk1() {
        String idCode = "1R";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk2() {
        String idCode = "2W";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk3() {
        String idCode = "3A";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk4() {
        String idCode = "4G";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk5() {
        String idCode = "5M";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk6() {
        String idCode = "6Y";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk7() {
        String idCode = "7F";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk8() {
        String idCode = "8P";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk9() {
        String idCode = "9D";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk10() {
        String idCode = "10X";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk11() {
        String idCode = "11B";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk12() {
        String idCode = "12N";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk13() {
        String idCode = "13J";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk14() {
        String idCode = "14Z";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk15() {
        String idCode = "15S";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk16() {
        String idCode = "16Q";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk17() {
        String idCode = "17V";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk18() {
        String idCode = "18H";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk19() {
        String idCode = "19L";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk20() {
        String idCode = "20C";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk21() {
        String idCode = "21K";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonOk22() {
        String idCode = "22E";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("DNI", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonKo() {
        String idCode = "22F";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            fail("should throw IDValidationException");
        } catch (IdValidationException e) {
            // expected behaviour
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypePhysicalPersonwRONGfORMAT() {
        String idCode = "22AF";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            fail("should throw IDValidationException");
        } catch (IdValidationException e) {
            // expected behaviour
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeNAValue() {
        String idCode = "1R";
        String idType = "NA";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            assertEquals("NA", result);
        } catch (IdValidationException e) {
            fail("IDValidationException");
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeIDCodeEmpty() {
        String idCode = "";
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            fail("should throw IDValidationException");
        } catch (IdValidationException e) {
            // expected behaviour
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdCodeNull() {
        String idCode = null;
        String idType = "ID";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            fail("should throw IDValidationException");
        } catch (IdValidationException e) {
            // expected behaviour
        }
    }

    @Test
    public void testDetermineAndValidateSpainIdTypeUnknown() {
        String idCode = "1R";
        String idType = "UNKNOWN";
        try {
            String result = IDUtils.determineAndValidateSpainIdType(idCode, idType);
            fail("should throw IDValidationException");
        } catch (IdValidationException e) {
            // expected behaviour
        }
    }

}
