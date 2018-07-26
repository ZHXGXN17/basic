package com.basic.newfea.enu.dao;

import com.basic.newfea.enu.entity_enum.Signal;

public class TrafficLight {
	Signal color = Signal.RED;
	public void change() {
		switch (color) {
		case RED:
			color = Signal.GREEN;
			break;
		case YELLOW:
			color = Signal.RED;
			break;
		case GREEN:
			color = Signal.YELLOW;
			break;
		}
	}
}