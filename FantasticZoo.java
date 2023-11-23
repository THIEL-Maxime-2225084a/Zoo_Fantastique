package proj;

import java.util.List;
import java.util.ArrayList;
public class FantasticZoo {
  String zooName;
  Master master;
  int maxEnclosuresNb;
  List<Enclosure> enclosures = new ArrayList<>();
  public FantasticZoo(String zooName, Master master, int maxEnclosuresNb, List<Enclosure> enclosures) {
    this.zooName = zooName;
    this.master = master;
    this.maxEnclosuresNb = maxEnclosuresNb;
    this.enclosures = enclosures;
  }

  public String getZooName() {
    return this.zooName;
  }

  public Master getMaster() {
    return this.master;
  }

  public int getMaxEnclosuresNb() {
    return this.maxEnclosuresNb;
  }

  public List<Enclosure> getEnclosures() {
    return this.enclosures;
  }
}