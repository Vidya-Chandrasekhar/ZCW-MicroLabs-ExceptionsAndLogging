package com.zipcodewilmington.exceptions;

import java.io.IOException;
//Upon instantiating a new PhoneNumber object, it is possible to receive a InvalidPhoneNumberFormatException
// if the String passed into the PhoneNumber constructor does not fit the format (###)-###-####.
//InvalidPhoneNumberFormatException extends IOException, which is a checked exception.Modify the createPhoneNumber
//method so that it throws any resulting InvalidPhoneNumberFormatException.  This will ensure that any method
// calling createPhoneNumber will have to handle the exception.

/**
 * Created by leon on 5/10/17.
 */ // Checked Exception
public final class InvalidPhoneNumberFormatException extends IOException {


}
