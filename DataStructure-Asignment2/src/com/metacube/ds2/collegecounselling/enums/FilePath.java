package com.metacube.ds2.collegecounselling.enums;

public enum FilePath {
	COLLEGE_LIST {
		@Override
		public String toString(){
			return "src/com/metacube/ds2/collegecounselling/filestore/College.txt";
		}
	},
	STUDENT_LIST {
		@Override
		public String toString(){
			return "src/com/metacube/ds2/collegecounselling/filestore/Student.txt";
		}
	};
}
