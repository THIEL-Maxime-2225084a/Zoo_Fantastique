package proj;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Creature {
  private String speciesName;
  private String gender;
  private double weight;
  private double tall;
  private int age;
  private int hungryIndicator;
  private boolean sleepIndicator;
  private int healthIndicator;
  private String emittedSound;
  private String ability;
  private String reproductionMode;
  List<Lycanthrope> lycList = new ArrayList<>();

  public Creature(String speciesName, String gender, double weight, double tall, int age, int hungryIndicator,
      boolean sleepIndicator, int healthIndicator, String emittedSound) {
    this.speciesName = speciesName;
    this.gender = gender;
    this.weight = weight;
    this.tall = tall;
    this.age = age;
    this.hungryIndicator = hungryIndicator;
    this.sleepIndicator = sleepIndicator;
    this.healthIndicator = healthIndicator;
    this.emittedSound = emittedSound;

    if (speciesName.equals("lycanthrope")) {
      Lycanthrope lyc = new Lycanthrope (this, (int) Math.round(30 + Math.random() * 70), 1, (Math.random() < 0.7) ? "β" : "ω", 1, (int) Math.round(30 + Math.random() * 70), (Math.random() < 0.8) ? true : false);
      lycList.add(lyc);
    }
  }

  public String getSpeciesName() {
    return this.speciesName;
  }

  public String getGender() {
    return this.gender;
  }

  public double getWeight() {
    return this.weight;
  }

  public double getTall() {
    return this.tall;
  }

  public int getAge() {
    return this.age;
  }

  public int getHungryIndicator() {
    return this.hungryIndicator;
  }

  public boolean getSleepIndicator() {
    return this.sleepIndicator;
  }

  public int getHealthIndicator() {
    return this.healthIndicator;
  }

  public String getEmittedSound() {
    return this.emittedSound;
  }

  public List<Lycanthrope> getLycList() {
    return lycList;
  }

  public void setHungryIndicator(int hungryIndicator) {
    this.hungryIndicator = hungryIndicator;
  }

  public void setSleepIndicator(boolean sleepIndicator) {
    this.sleepIndicator = sleepIndicator;
  }

  public void setHealthIndicator(int healthIndicator) {
    this.healthIndicator = healthIndicator;
  }

  public void feed() {
    if (this.sleepIndicator == false) {
      if (hungryIndicator + 10 <= 100) {
        this.hungryIndicator += 10;
      }
      else {
        this.hungryIndicator = 100;
      }
    }
  }

  public void heal() {
    if (healthIndicator + 10 <= 100) {
      this.healthIndicator += 10;
    }
    else {
      this.healthIndicator = 100;
    }
  }

  public void sleepOrWake(String action) {
    if (action == "dormir") {
      this.sleepIndicator = true;
    } 
    else if (action == "se réveiller") {
      this.sleepIndicator = false;
    }
  }

  public void growOlder() {
    this.age += 1;
  }

  public void initAbility() {
    if (Arrays.asList("licorne", "lycanthrope", "dragon").contains(this.speciesName)) {
      ability = "court";
    }
    if (Arrays.asList("kraken", "sirène", "mégalodon", "dragon").contains(this.speciesName)) {
      ability = "nage";
    }
    if (Arrays.asList("dragon", "phénix").contains(this.speciesName)) {
      ability = "vole";
    }
  }

  public String initReproductionMode() {
    if (this.gender == "femelle") {
      if (Arrays.asList("lycanthrope", "licorne", "nymphe", "sirène").contains(this.speciesName)) {
        reproductionMode = "vivipare";
      }
      if (Arrays.asList("kraken", "mégalodon", "phénix", "dragon").contains(this.speciesName)) {
        reproductionMode = "ovipare";
      }
    }
    else if (this.gender == "mâle") {
      reproductionMode = "-";
    }
    return reproductionMode;
  }
}
