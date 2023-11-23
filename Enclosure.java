package proj;

import java.util.List;
import java.util.ArrayList;
public class Enclosure {
  String enclosureName;
  int area;
  int maxCreaturesNb;
  int creaturesNb;
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
    this.creatures.add(theCreature);
  }

  public void removeCreature(Creature theCreature) {
    this.creatures.remove(theCreature);
  }

  public void feedCreatures(int plus) {
    for (int i = 0; i < this.creaturesNb; ++i) {
      this.creatures.get(i).eat(plus);
    }
  }

  public void clean() {
    if (this.cleanliness == "mauvais" && this.creaturesNb == 0) {
      this.cleanliness = "bon";
    }
  }
}
