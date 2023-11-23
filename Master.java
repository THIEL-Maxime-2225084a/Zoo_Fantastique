package proj;

public class Master {
  String masterName;
  String gender;
  int age;
  public Master(String masterName, String gender, int age) {
    this.masterName = masterName;
	this.gender = gender;
	this.age = age;
  }

  public String getMasterName() {
    return this.masterName;
  }

  public String getGender() {
    return this.gender;
  }

  public int getAge() {
    return this.age;
  }
}