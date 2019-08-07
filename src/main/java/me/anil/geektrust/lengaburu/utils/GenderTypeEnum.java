package me.anil.geektrust.lengaburu.utils;

/*
 * Enum type used to denote different gender
 */
public enum GenderTypeEnum {

	MALE("Male"), FEMALE("Female");

	String value;

	private GenderTypeEnum(String value) {
		this.value = value;
	}

	public static GenderTypeEnum getGenderType(String value) {
		for (GenderTypeEnum gender : GenderTypeEnum.values()) {
			if (gender.value.equals(value)) {
				return gender;
			}
		}
		return null;
	}

}
