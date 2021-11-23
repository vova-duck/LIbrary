package HomeWork14_2;

public class Genre {
   private String title;
   private String description;

   public Genre(String title, String description){
      this.title = title;
      this.description = description;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String toString(){
      return "Title " + this.title + " description " +  this.description;
   }

   public void printGenre(){
      System.out.println(this);
   }

}
