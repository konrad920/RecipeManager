package Entities;

public class Recipe extends EntityBase{
    private String title;
    private String description;

    public Recipe(String title, String description){
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
