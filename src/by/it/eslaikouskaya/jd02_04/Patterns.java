package by.it.eslaikouskaya.jd02_04;

class Patterns {

	private Patterns() {
	}

	static final String BRACKETS="[(]([A-Za-z]|(-?\\d+(\\.\\d+)?))(([-+*/=])([A-Za-z]|(-?\\d+(\\.\\d+)?)))+[)]]";
	static final String OPERATION="(?<=[^-+*=/,{])([-+*/=])";
	static final String SCALAR="-?\\d+(\\.\\d+)?";
	static final String VECTOR="[{]((-?\\d+(\\.\\d+)?),?\\s?)+[}]";
	static final String MATRIX="[{]([{]((-?\\d+(\\.\\d+)?),?\\s?)+[}],?\\s?)+[}]";
}