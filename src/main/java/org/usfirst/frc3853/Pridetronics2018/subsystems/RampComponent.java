
package org.usfirst.frc3853.Pridetronics2018.subsystems;

/*import com.fasterxml.jackson.annotation.JsonCreator;
import org.jetbrains.annotations.NotNull;
import org.usfirst.frc.team449.robot.other.Clock;

import java.util.function.DoubleUnaryOperator;*/

/**
 * A component for limiting the rate of change of a value.
 */
public class RampComponent {

    /**
     * The maximum allowed change in the value per second.
     */
    private final double _maxChange;

    /**
     * The value most recently returned.
     */
    private double lastValue;

   
    public RampComponent(double maxChange) {
        _maxChange = maxChange;
        
        lastValue = 0.0;
    }

    /**
     * Ramp the given value.
     *
     * @param value The current value of whatever it is you're ramping
     * @return The ramped version of that value.
     */
   
    public double applyAsDouble(double value) {
    	double change = value - lastValue;
        if (java.lang.Math.abs(change) >= _maxChange) {
        	change = java.lang.Math.signum(change)*_maxChange;
        }
		
        value = change + value;
        
        return value;
    }

	public void reset(){
		lastValue = 0;
	}

    /**
     * Get an a copy of this object.
     *
     * @return a new {@link RampComponent} with the same max change per second
     */

}