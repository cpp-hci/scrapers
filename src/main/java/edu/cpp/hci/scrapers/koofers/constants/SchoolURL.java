package edu.cpp.hci.scrapers.koofers.constants;

public enum SchoolURL {
    CAL_POLY_POMONA("california-state-polytechnic-university-pomona-csupomona"),
    UC_SAN_DIEGO("university-of-california-san-diego-ucsd");

    private final String school;

    private SchoolURL(String school) {
        this.school = school;
    }

    public String toString() {
        return this.school;
    }
}
