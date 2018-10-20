package by.task.raikiry.service.impl.util;

import by.task.raikiry.entity.Email;
import by.task.raikiry.entity.Person;
import by.task.raikiry.entity.Phone;

import java.util.List;


public class FromUpdate {

    public static void updateFieldPerson(Person dbPerson, Person updPerson){
        dbPerson.setName(updPerson.getName());
        dbPerson.setComment(updPerson.getComment());
        dbPerson.setAddress(updPerson.getAddress());
    }

    public static void updateSetEmails(List<Email> dbSetEmail, List<Email> upSetEmail){
        for (Email dbEmail: dbSetEmail){
            for (Email upEmail: upSetEmail){
                if (dbEmail.getId().equals(upEmail.getId())){
                    FromUpdate.updateFieldEmail(dbEmail, upEmail);
                }
            }
        }
    }

    public static void updateSetPhones (List<Phone> dbSetPhone, List<Phone> upSetPhone){
        for (Phone dbPhone: dbSetPhone){
            for (Phone upPhone: upSetPhone){
                if (dbPhone.getId().equals(upPhone.getId())){
                    FromUpdate.updateFieldPhone(dbPhone, upPhone);
                }
            }
        }
    }

    private static void updateFieldEmail(Email dbEmail, Email upEmail){
        dbEmail.setEmailVal(upEmail.getEmailVal());
    }

    private static void updateFieldPhone(Phone dbPhone, Phone upPhone){
        dbPhone.setPhoneNumber(upPhone.getPhoneNumber());
    }

}
