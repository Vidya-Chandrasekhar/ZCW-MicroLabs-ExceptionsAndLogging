package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = LoggerFactory.getLogger(PhoneNumberFactory.class);

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {

        PhoneNumber[] phoneArray = new PhoneNumber[phoneNumberCount];

        phoneArray[0] = createRandomPhoneNumber();
        for (int i = 0; i < phoneNumberCount; i++) {
            phoneArray[i] = createRandomPhoneNumber();
        }
        return phoneArray;
    }


    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    private static PhoneNumber createRandomPhoneNumber() {

        RandomNumberFactory randNum = new RandomNumberFactory() {
        };

        int areaCode = randNum.createInteger(100, 999);
        int centralOfficeCode = randNum.createInteger(100, 999);
        int phoneLineCode = randNum.createInteger(1000, 9999);

        return createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        try {
            String phoneNumber = "(" + areaCode + ")" + "-" + centralOfficeCode + "-" + phoneLineCode;
            return createPhoneNumber(phoneNumber);
        } catch (InvalidPhoneNumberFormatException e) {

            logger.info("(" + areaCode + ")" + "-" + centralOfficeCode + "-" + phoneLineCode + " is not a valid phone number ");
            //e.printStackTrace();
            return null;
        }

    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {


        PhoneNumber phone = new PhoneNumber(phoneNumberString);

        logger.info("Attempting to create a new PhoneNumber object with a value of " + "(" + phone.getAreaCode() + ")" + "-" + phone.getCentralOfficeCode() + "-" + phone.getPhoneLineCode());
        return phone;

    }
}
