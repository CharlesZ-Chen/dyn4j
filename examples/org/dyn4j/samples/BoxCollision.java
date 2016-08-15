/*
 * Copyright (c) 2010-2016 William Bittle  http://www.dyn4j.org/
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted 
 * provided that the following conditions are met:
 * 
 *   * Redistributions of source code must retain the above copyright notice, this list of conditions 
 *     and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above copyright notice, this list of conditions 
 *     and the following disclaimer in the documentation and/or other materials provided with the 
 *     distribution.
 *   * Neither the name of dyn4j nor the names of its contributors may be used to endorse or 
 *     promote products derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR 
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND 
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR 
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL 
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, 
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER 
 * IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.dyn4j.samples;

import java.awt.Graphics2D;

import org.dyn4j.dynamics.World;
import org.dyn4j.geometry.Geometry;
import org.dyn4j.geometry.MassType;

public final class BoxCollision extends SimulationFrame {
	/** The serial version id */
	private static final long serialVersionUID = -8518496343422955267L;

	private SimulationBody box1;
	/**
	 * Default constructor.
	 */
	public BoxCollision() {
		super("Billiards", 300.0);
	}
	
	/* (non-Javadoc)
	 * @see org.dyn4j.samples.SimulationFrame#initializeWorld()
	 */
	@Override
	protected void initializeWorld() {
		// no gravity on a top-down view of a billiards game
		this.world.setGravity(World.ZERO_GRAVITY);
		
		// create all your bodies/joints
		
		box1 = new SimulationBody();
		box1.addFixture(Geometry.createRectangle(0.2, 0.2));
		box1.translate(0.0, 0.0);
		box1.setLinearVelocity(0.5, 0.0);
		box1.setMass(MassType.NORMAL);
		this.world.addBody(box1);
		
		SimulationBody box2 = new SimulationBody();
		box2.addFixture(Geometry.createRectangle(0.2, 0.2));
		box2.translate(1.0, 0.0);
		box2.setMass(MassType.NORMAL);
		this.world.addBody(box2);
	}
	
	/* (non-Javadoc)
	 * @see org.dyn4j.samples.SimulationFrame#render(java.awt.Graphics2D, double)
	 */
	@Override
	protected void render(Graphics2D g, double elapsedTime) {
		// move the view a bit
		g.translate(-200, 0);

		super.render(g, elapsedTime);
	}
	
	/**
	 * Entry point for the example application.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		BoxCollision simulation = new BoxCollision();
		simulation.run();
	}
}
