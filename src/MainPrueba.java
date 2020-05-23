public class MainPrueba {


    public static void main(String[] args) {
        FileComponent textos = new Folder("TXT'S", "12:59am", "D:/Master/CarpetaPrincipal");
        FileComponent ppt = new Folder("PowerPoints", "12:59am", "D:/Master/CarpetaPrincipal");
        FileComponent words = new Folder("Archivo Words", "12:59am", "D:/Master/CarpetaPrincipal");


        FileComponent carpetaPrincipal = new Folder("Principal", "12:59am", "D:/Master");

        carpetaPrincipal.add(textos);
        carpetaPrincipal.add(ppt);
        carpetaPrincipal.add(words);

        textos.add(new File("lista de compras", "01:02pm", "D:/Master/carpetaPrinciapal/TXT'S"));
        textos.add(new File("tareas", "01:02pm", "D:/Master/carpetaPrinciapal/TXT'S"));

        ppt.add(new File("Presentacion 1", "01:02pm", "D:/Master/carpetaPrinciapal/PowerPoints"));
        ppt.add(new File("Presentacion 2", "01:02pm", "D:/Master/carpetaPrinciapal/PowerPoints"));

        words.add(new File("Ensayo 1", "01:02pm", "D:/Master/carpetaPrinciapal/Archivo Words"));


        Archivero master = new Archivero(carpetaPrincipal);
        master.getFileList();

        Ventana ventana = new Ventana(master.getMasterNode());

    }


}
