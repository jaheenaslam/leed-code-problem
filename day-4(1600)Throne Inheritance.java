import java.util.*;

class ThroneInheritance {
    private String king;
    private Map<String, List<String>> familyTree;
    private Set<String> dead;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.familyTree = new HashMap<>();
        this.dead = new HashSet<>();
        familyTree.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        familyTree.putIfAbsent(parentName, new ArrayList<>());
        familyTree.get(parentName).add(childName);
        familyTree.put(childName, new ArrayList<>());
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }
    private void dfs(String current, List<String> order) {
        if (!dead.contains(current)) {
            order.add(current);
        }
        if (familyTree.containsKey(current)) {
            for (String child : familyTree.get(current)) {
                dfs(child, order);
            }
        }
    }
}
