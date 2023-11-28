package proj;

public class Lycanthrope {
  Creature lyc;
  int strength;
  int dominationFactor;
  String dominationRank;
  int level;
  int impetuosityFactor;
  boolean pack;
  String ageCategory;

  public Lycanthrope(Creature lyc, int strength, int dominationFactor, String dominationRank, int level, int impetuosityFactor, boolean pack) {
    this.lyc = lyc;
    this.strength = strength;
    this.dominationFactor = dominationFactor;
    this.dominationRank = dominationRank;
    this.level = level;
    this.impetuosityFactor = impetuosityFactor;
    this.pack = pack;
  }

  public String initAgeCategory() {
    if (0 <= lyc.getAge() && lyc.getAge() < 20) {
      ageCategory = "jeune";
    } 
    else if (20 <= lyc.getAge() && lyc.getAge() < 40) {
      ageCategory = "adulte";
    } 
    else if (40 <= lyc.getAge()) {
      ageCategory = "vieux";
    }
    return ageCategory;
  }

  public Creature getLyc() {
    return this.lyc;
  }

  public int getStrength() {
    return this.strength;
  }

  public int getDominationFactor() {
    return this.dominationFactor;
  }

  public String getDominationRank() {
    return this.dominationRank;
  }

  public int getLevel() {
    return this.level;
  }

  public int getImpetuosityFactor() {
    return this.impetuosityFactor;
  }

  public boolean getPack() {
    return this.pack;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public void setDominationFactor(int dominationFactor) {
    this.dominationFactor = dominationFactor;
  }

  public void setDominationRank(String dominationRank) {
    this.dominationRank = dominationRank;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public void setPack(boolean pack) {
    this.pack = pack;
  }
}
