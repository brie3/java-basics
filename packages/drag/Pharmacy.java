package packages.drag;

import java.util.Iterator;
import java.util.List;

public class Pharmacy implements Iterable<Component>, Comparable<Pharmacy> {
    private List<Component> components;
    int index;

    public Pharmacy(List<Component> components) {
        this.components = components;
        this.index = 0;
    }

    @Override
    public Iterator<Component> iterator() {
        return new Iterator<Component>() {
            @Override
            public boolean hasNext() {
                return index < components.size();
            }

            @Override
            public Component next() {
                return components.get(index++);
            }
        };
    }

    public int getDrugPower() {
        int power = 0;
        for (Component component : components) {
            power += component.getPower();
        }
        return power;
    }

    @Override
    public String toString() {
        return String.format(
                "%s {components: %s, power: %s}%n",
                this.getClass().getSimpleName(),
                components, getDrugPower());
    }

    @Override
    public int compareTo(@NotNull Pharmacy o) {
        int power = getDrugPower();
        int comparison1 = Integer.compare(power, o.getDrugPower());
        return comparison1 == 0 ? compareComponents(o.components) : comparison1;
    }

    public int compareComponents(List<Component> componentsToCompare) {
        int comparedLess = 0;
        int comparedMore = 0;
        for (Component c : this.components) {
            for (Component c1 : componentsToCompare) {
                if (c.compareTo(c1) < 0)
                    comparedLess++;
                else if (c.compareTo(c1) > 0)
                    comparedMore++;
            }
        }
        return Integer.compare(comparedMore, comparedLess);
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (Component c : this.components) {
            result += c.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        return compareTo((Pharmacy) obj) == 0;
    }
}
