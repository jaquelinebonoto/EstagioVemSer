
package lista1;

public class TesteCurso {
    public static void main(String[] args) {
        //Curso curso1= new Curso();
        //System.out.println(curso1.toString());
        Data data1 = new Data();
        Curso curso2 = new Curso("Java 1", 8.0, data1);
        System.out.println(curso2.toString());
        Data data2 = new Data (20, 8, 2014);
        Curso curso3 = new Curso("Java 2", 8.9, data2);
        System.out.println(curso3.toString());
        
        
        Curso curso4 = new Curso();
        curso4.setData(data1);
        System.out.println(curso4);
        
        Curso curso5 = new Curso("Java 3", 5.9, data1);
        System.out.println(curso5.toString());
        
        data1.setAno(2013);
        System.out.println(curso5.toString());
        System.out.println(curso5.getData());
    }
}
