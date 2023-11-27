package proj;

import java.util.List;
import java.util.ArrayList;
public class Enclosure {
  String enclosureName;
  int area;
  int maxCreaturesNb;
  List<Creature> creatures = new ArrayList<>();
  String cleanliness;
  public Enclosure(String enclosureName, int area, int maxCreaturesNb, List<Creature> creatures, String cleanliness) {
    this.enclosureName = enclosureName;
    this.area = area;
    this.maxCreaturesNb = maxCreaturesNb;
    this.creatures = creatures;
    this.cleanliness = cleanliness;
  }

  public String getEnclosureName() {
    return this.enclosureName;
  }

  public int getArea() {
    return this.area;
  }

  public int getMaxCreaturesNb() {
    return this.maxCreaturesNb;
  }

  public List<Creature> getCreatures() {
    return this.creatures;
  }

  public String getCleanliness() {
    return this.cleanliness;
  }

  public void addCreature(Creature theCreature) {
    List<Creature> creatures2 = new ArrayList<>(creatures);
    creatures2.add(theCreature);
    this.creatures = creatures2;
  }

  public void removeCreature(Creature theCreature) {
    List<Creature> creatures2 = new ArrayList<>(creatures);
    creatures2.remove(theCreature);
    this.creatures = creatures2;
  }

  public void feedCreatures(int plus) {
    for (int i = 0; i < this.creatures.size(); ++i) {
      this.creatures.get(i).setHungryIndicator(plus);
    }
  }

  public String clean() {
    if ((this.cleanliness == "mauvais" || this.cleanliness == "correct") && this.creatures.size() == 0) {
      this.cleanliness = "bon";
      return "fait";
    }
    else {
      return "pas possible";
    }
  }
}

