package com.kizio.colourblind.simulation;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorLong;

/**
 * Enumerated type representing the different kinds of colour blindness.
 *
 * @author Graeme Sutherland
 * @since 06/08/2018
 */
public enum ColourBlindnessType {

	/**
	 * Represents normal vision.
	 */
	NORMAL {
		@Override
		public int getColour (@ColorInt final int rgbValue) {
			return rgbValue;
		}

		@Override
		public long getColour (@ColorLong final long rgbValue) {
			return rgbValue;
		}

		@Override
		public Color getColour (final Color colour) {
			return colour;
		}
	},

	/**
	 * Unable to perceive red light.
	 */
	PROTANOPIA,

	/**
	 * Reduced sensitivity to red light.
	 */
	PROTANOMALY,

	/**
	 * Unable to perceive green light.
	 */
	DEUTERANOPIA,

	/**
	 * Reduced sensitivity to green light. This is the most common form.
	 */
	DEUTERANOMALY,

	/**
	 * Unable to perceive blue light.
	 */
	TRITANOPIA,

	/**
	 * Reduced sensitivity to blue light.
	 */
	TRITANOMALY,

	/**
	 * Monochrome vision. This is very rare.
	 */
	ACHROMATOPSIA,

	/**
	 * Reduced sensitivity to all colours.
	 */
	ACHROMATOMALY;

	/**
	 * Converts the supplied RGB value into the corresponding shade to represent a form of colour
	 * blindness.
	 *
	 * @param rgbValue An {@code int} RGB value representing the colour at the given pixel
	 * @return An {@code int} RGB value representing the translated colour
	 */
	public int getColour (@ColorInt final int rgbValue) {
		final int result;

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			result = getColour (Color.valueOf(rgbValue)).toArgb();
		} else {
			// TODO Manually split the long into int ARGB values, and process.
			result = rgbValue;
		}

		return result;	}

	/**
	 * Converts the supplied RGB value into the corresponding shade to represent a form of colour
	 * blindness.
	 *
	 * @param rgbValue An {@code long} RGB value representing the colour at the given pixel
	 * @return An {@code long} RGB value representing the translated colour
	 */
	@TargetApi(Build.VERSION_CODES.O)
	public long getColour (@ColorLong final long rgbValue) {
		final long result;

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			result = getColour (Color.valueOf(rgbValue)).pack();
		} else {
			// TODO Manually split the long into int ARGB values, and process.
			result = rgbValue;
		}

		return result;
	}

	/**
	 * Converts a supplied {@link Color} into the colour blind form.
	 *
	 * @param colour The {@link Color} to convert
	 * @return The converted {@link Color}
	 */
	@TargetApi(Build.VERSION_CODES.O)
	public Color getColour (final Color colour) {
		return colour;
	}
}
