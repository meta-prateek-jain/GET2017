package com.metacube.ds2.collegecounselling.enums;

/**
 * Enum Class for Status
 * @author Prateek Jain
 *
 */
public enum Status {
	EMPTY{
        @Override
        public String toString() {
            return "Empty";
        }
    }, NOT_EMPTY{
        @Override
        public String toString() {
            return "Not_Empty";
        }
    },  REMOVED{
        @Override
        public String toString() {
            return "Removed";
        }
    }, UPDATED{
        @Override
        public String toString() {
            return "Updated";
        }
    }, RETRIEVED{
        @Override
        public String toString() {
            return "Retrieved";
        }
    }, DUPLICATE{
        @Override
        public String toString() {
            return "Duplicate";
        }
    }, FAILED{
        @Override
        public String toString() {
            return "Failed";
        }
    }, ADDED{
        @Override
        public String toString() {
            return "Added";
        }
    }, PRESENT{
        @Override
        public String toString() {
            return "Present";
        }
    }, NOT_PRESENT{
        @Override
        public String toString() {
            return "Not_Present";
        }
    }, INVALID{
        @Override
        public String toString() {
            return "InValid";
        }
    }, VALID{
        @Override
        public String toString() {
            return "Valid";
        }
    } ; 
}
