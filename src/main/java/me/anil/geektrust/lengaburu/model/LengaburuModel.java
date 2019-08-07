package me.anil.geektrust.lengaburu.model;

import java.util.LinkedHashMap;
import java.util.Map;

import me.anil.geektrust.lengaburu.utils.GenderTypeEnum;

public class LengaburuModel {

	private Person king;

	private Person queen;

	private static LengaburuModel lengaburu;

	private static Map<String, Person> members;

	public Person getKing() {
		return king;
	}

	public void setKing(Person king) {
		this.king = king;
	}

	public Person getQueen() {
		return queen;
	}

	public void setQueen(Person queen) {
		this.queen = queen;
	}

	private LengaburuModel() {

	}

	public static LengaburuModel getLengaburuModel() {
		if (lengaburu == null) {
			lengaburu = new LengaburuModel();
			Person king = new Person("King Shan", GenderTypeEnum.MALE);
			Person queen = new Person("Queen Anga", GenderTypeEnum.FEMALE);
			king.setSpouse(queen);
			queen.setSpouse(king);
			lengaburu.setKing(king);
			lengaburu.setQueen(queen);
			members = new LinkedHashMap<String, Person>();
			members.put(king.getName(), king);
			members.put(queen.getName(), queen);
		}
		return lengaburu;
	}

	public static void addNewMember(String name, Person person) {
		members.put(name, person);
	}

	public static Person getMember(String name) {
		return members.get(name);
	}

}
