package pt.isec.a21230268.bolagiroscopio;


public class Position {
    float posActual, limInf, limSup, vel;

    Position(float pos, float limInf, float limSup, float vel) {
        this.posActual = pos;
        this.limInf = limInf;
        this.limSup = limSup;
        this.vel = vel;
    }

    float getPos() {
        return posActual;
    }

    void actLimites(float limInf, float limSup) {

    }

    float actualiza(float acel, int dt) {
        vel = vel + acel*dt;
        posActual = posActual + vel*dt;

        if (posActual < limInf) {
            posActual = limInf;
            vel = -0.7f * vel;
        } else if ( posActual > limSup) {
            posActual = limSup;
            vel = -0.7f * vel;
        }
        return posActual;
    }
}
