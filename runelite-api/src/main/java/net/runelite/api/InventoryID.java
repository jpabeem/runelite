/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.api;

<<<<<<< HEAD
/**
 * An enumeration of possible inventory types.
 */
public enum InventoryID
{
	/**
	 * Standard player inventory.
	 */
	INVENTORY(93),
	/**
	 * Equipment inventory.
	 */
	EQUIPMENT(94),
	/**
	 * Bank inventory.
	 */
	BANK(95),
	/**
	 * A puzzle box inventory.
	 */
	PUZZLE_BOX(140),
	/**
	 * Barrows reward chest inventory.
	 */
	BARROWS_REWARD(141);
=======
public enum InventoryID
{
	INVENTORY(93),
	EQUIPMENT(94),
	BANK(95),
	PUZZLE_BOX(140);
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b

	private final int id;

	InventoryID(int id)
	{
		this.id = id;
	}

<<<<<<< HEAD
	/**
	 * Gets the raw inventory type ID.
	 *
	 * @return inventory type
	 */
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	public int getId()
	{
		return id;
	}
}
