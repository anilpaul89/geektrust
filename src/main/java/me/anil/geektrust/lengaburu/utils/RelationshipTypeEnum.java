package me.anil.geektrust.lengaburu.utils;

/*
 * Enum Class used to denote the relationshop type
 */
public enum RelationshipTypeEnum {

	PATERNAL_UNCLE("Paternal-Uncle"), MATERNAL_UNCLE("Maternal-Uncle"), PATERNAL_AUNT("Paternal-Aunt"),
	MATERNAL_AUNT("Maternal-Aunt"), SISTER_IN_LAW("Sister-In-Law"), BROTHER_IN_LAW("Brother-In-Law"), SON("Son"),
	DAUGHTER("Daughter"), SIBLINGS("Siblings");

	String value;

	RelationshipTypeEnum(String value) {
		this.value = value;
	}
	
	public static RelationshipTypeEnum getRelationShip(String value) {
		for (RelationshipTypeEnum relation : RelationshipTypeEnum.values()) {
			if (relation.value.equals(value)) {
				return relation;
			}
		}
		return null;
	}
}
