package edu.cpp.hci.scrapers.constants;

public enum School {
    CAL_POLY_POMONA("California State Polytechnic University, Pomona"),
    UC_SAN_DIEGO("University of California San Diego");

    private final String school;

    School(final String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return school;
    }
}
