package Interfaces;

import Entities.User;

public interface PersonValidityService<T extends User> {
    boolean checkPersonValidity(T user);
}
