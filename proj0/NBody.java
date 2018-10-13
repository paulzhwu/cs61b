class NBody {

    public static double readRadius(String fileName){
        In in = new In(fileName);
        int num = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int num = in.readInt();
        double radius = in.readDouble();
        Planet[] allPlants = new Planet[num];
        for (int i=0; i<num;i++) {
            allPlants[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        }
        return allPlants;
    }

    public static void main(String[] args){
        String TString = args[0];
        String dtString = args[1];
        Double T = Double.valueOf(TString);
        Double dt = Double.valueOf(dtString);
        String filename = args[2];
        Planet[] allPlants = readPlanets(filename);
        double radius = readRadius(filename);
        StdDraw.setScale(-radius,radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Planet p:allPlants) {
            p.draw();
        }
        StdDraw.enableDoubleBuffering();
        for (double t=0; t<T; t+=dt){
            StdDraw.pause(10);
            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");
            double[] fx_arr = new double[allPlants.length];
            double[] fy_arr = new double[allPlants.length];
            for (int i=0;i<allPlants.length;i++) {
                fx_arr[i] = allPlants[i].calcNetForceExertedByX(allPlants);
                fy_arr[i] = allPlants[i].calcNetForceExertedByY(allPlants);
            }
            for (int i=0;i<allPlants.length;i++) {
                allPlants[i].update(dt,fx_arr[i],fy_arr[i]);
            }
            for (Planet p:allPlants) {
                p.draw();
            }
            StdDraw.show();
        }
        StdOut.println(allPlants.length);
        StdOut.println(radius);
        for (Planet p: allPlants) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %s\n",p.xxPos,p.yyPos,p.xxVel,p.yyVel,p.mass,p.imgFileName);
        }
    }
}