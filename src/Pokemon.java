public class Pokemon {

    private int numPokemon;
    private String name;
    private String type;
    private int level;
    private int hp;
    private int attack;
    private int defense;

    public Pokemon(String name, String type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
    }

    public Pokemon(int numPokemon, String name, String type, int level, int hp, int attack, int defense) {
        this.numPokemon = numPokemon;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    public int getNumPokemon() {
        return numPokemon;
    }

    public void setNumPokemon(int numPokemon) {
        this.numPokemon = numPokemon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return String.format("%s -> Type: %s | Level: %s", name, type, level);
    }
}
