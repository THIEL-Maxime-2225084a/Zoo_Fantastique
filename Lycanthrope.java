package proj;

public class Lycanthrope {
  String gender;
  String ageCategory;
  int strength;
  int dominationFactor;
  int dominationRank;
  int level;
  int impetuosityFactor;
  String pack;
  public Lycanthrope(String gender, String ageCategory, int strength, int dominationFactor, int dominationRank, int level, int impetuosityFactor, String pack) {
    this.gender = gender;
	this.ageCategory = ageCategory;
	this.strength = strength;
	this.dominationFactor = dominationFactor;
	this.dominationRank = dominationRank;
	this.level = level;
	this.impetuosityFactor = impetuosityFactor;
	this.pack = pack;
  }

  public String getGender() {
    return this.gender;
  }

  public String getAgeCategory() {
    return this.ageCategory;
  }

  public int getStrength() {
	return this.strength;
  }

  public int getDominationFactor() {
    return this.dominationFactor;
  }

  public int getDominationRank() {
    return this.dominationRank;
  }

  public int getLevel() {
    return this.level;
  }

  public int getImpetuosityFactor() {
    return this.impetuosityFactor;
  }

  public String getPack() {
    return this.pack;
  }

  public void setAgeCategory(String ageCategory) {
    this.ageCategory = ageCategory;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public void setDominationFactor(int dominationFactor) {
    this.dominationFactor = dominationFactor;
  }

  public void setDominationRank(int dominationRank) {
    this.dominationRank = dominationRank;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public void setPack(String pack) {
    this.pack = pack;
  } 
}