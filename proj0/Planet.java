class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet (double xP, double yP, double xV, double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet (Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
    }


    public double calcDistance(Planet p) {
        double deltaX = p.xxPos - this.xxPos;
        double deltaY = p.yyPos - this.yyPos;
        double rSqr = (deltaX*deltaX+ deltaY*deltaY);
        double r = Math.sqrt(rSqr);
        return r;
    }

    public double calcForceExertedBy (Planet p){
        double G = 6.67e-11;
        double r = this.calcDistance(p);
        double f = G*this.mass*p.mass/r/r;
        return f;
    }

    public double calcForceExertedByX( Planet p) {
        double deltaX = p.xxPos - this.xxPos;
        double f = this.calcForceExertedBy(p);
        double r = this.calcDistance(p);
        return f/r*deltaX;
    }

    public double calcForceExertedByY( Planet p) {
        double deltaY = p.yyPos - this.yyPos;
        double f = this.calcForceExertedBy(p);
        double r = this.calcDistance(p);
        return f/r*deltaY;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double totalForce = 0;
        for (Planet p:allPlanets) {
            if (!this.equals(p)) {
                totalForce += this.calcForceExertedByX(p);
            }
        }
        return totalForce;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double totalForce = 0;
        for (Planet p:allPlanets) {
            if (!this.equals(p)) {
                totalForce += this.calcForceExertedByY(p);
            }
        }
        return totalForce;
    }

    public void update (double t, double fX, double fY){
        this.xxVel += fX / this.mass * t;
        this.yyVel += fY / this.mass * t;
        this.xxPos += this.xxVel * t;
        this.yyPos += this.yyVel *t;
    }

}