package com.myorganization.myservice.bundle;

import org.springframework.context.MessageSource;
import springfox.documentation.service.ObjectVendorExtension;
import springfox.documentation.service.StringVendorExtension;

import java.util.Locale;

import static com.myorganization.myservice.constants.SwaggerConstants.*;

public class BundleDefinition{

    private MessageSource messageSource;

    private final String[] locales = {"en","es"};

    public ObjectVendorExtension createInfoExtension(){
        final ObjectVendorExtension infoExtension = new ObjectVendorExtension("x-translations");

        infoExtension.addProperty(createStringVendorExtension(APPLICATION_NAME_INFO_KEY, APPLICATION_NAME_INFO_PACKAGE_KEY));
        infoExtension.addProperty(createStringVendorExtension(TITLE_INFO_KEY, TITLE_INFO_PACKAGE_KEY));
        infoExtension.addProperty(createStringVendorExtension(DESCRIPTION_INFO_KEY, DESCRIPTION_INFO_PACKAGE_KEY));

        return infoExtension;
    }

    public ObjectVendorExtension createBundleExtensions(){
        final ObjectVendorExtension bundles = new ObjectVendorExtension("x-bundles");
        if(locales != null){
            for(final String locale : locales){
                bundles.addProperty(createBundle(locale));
            }
        }
        return bundles;
    }

    public ObjectVendorExtension createBundle(String locale){
        final ObjectVendorExtension bundle = new ObjectVendorExtension(locale);

        final Locale definedLocale = new Locale(locale);
        bundle.addProperty(createStringVendorExtension(SUMMARY_PACKAGE_KEY, getMessage("myservice.summary", definedLocale)));
        bundle.addProperty(createStringVendorExtension(SUMMARY_PACKAGE_IDVALIDATOR_KEY, getMessage("myservice.summary.idValidator", definedLocale)));
        bundle.addProperty(createStringVendorExtension(DESCRIPTION_PACKAGE_KEY, getMessage("myservice.description", definedLocale)));

        bundle.addProperty(createStringVendorExtension(APPLICATION_NAME_INFO_PACKAGE_KEY, getMessage("info.appName", definedLocale)));
        bundle.addProperty(createStringVendorExtension(TITLE_INFO_PACKAGE_KEY, getMessage("info.title", definedLocale)));
        bundle.addProperty(createStringVendorExtension(DESCRIPTION_INFO_PACKAGE_KEY, getMessage("info.description", definedLocale)));

        bundle.addProperty(createStringVendorExtension(INPUTTEXT_CODE_PARAM_PACKAGE_KEY, getMessage("inputText.param.name", definedLocale)));
        bundle.addProperty(createStringVendorExtension(SUMMARY_STATUS_PACKAGE_KEY, getMessage("status.summary", definedLocale)));
        bundle.addProperty(createStringVendorExtension(DESCRIPTION_STATUS_PACKAGE_KEY, getMessage("status.description", definedLocale)));

        bundle.addProperty(createStringVendorExtension(PATH_ID_VALIDATOR_DESCRIPTION_KEY, getMessage("idValidator.pathName", definedLocale)));
        return bundle;
    }

    private StringVendorExtension createStringVendorExtension(String key, String value){
        return new StringVendorExtension(key, value);
    }

    private String getMessage(String property, Locale locale){
        return messageSource.getMessage(property, null, locale);
    }

    public void setMessageSource(MessageSource messageSource){
        this.messageSource = messageSource;
    }

}