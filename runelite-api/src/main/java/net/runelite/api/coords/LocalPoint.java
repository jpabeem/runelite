/*
 * Copyright (c) 2018 Abex
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
package net.runelite.api.coords;

import javax.annotation.Nullable;
import lombok.Value;
import net.runelite.api.Client;
import net.runelite.api.Perspective;

/**
<<<<<<< HEAD
 * A two-dimensional point in the local coordinate space.
 * <p>
 * Local points are immutable, however since the local coordinate space moves,
 * it is not safe to keep a LocalPoint after a loading zone.
 * <p>
 * The unit of a LocalPoint is 1/128th of a tile.
=======
 * A LocolPoint is a Two-Dimensional point in the local coordinate space. Because the local coordinate space moves,
 * it is not safe to keep a LocalPoint after a loading zone. The unit is 1/128th of a Tile
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
 */
@Value
public class LocalPoint
{
<<<<<<< HEAD
	/**
	 * X and Y axis coordinates.
	 */
	private final int x, y;

	/**
	 * Gets the local coordinate at the center of the passed tile.
	 *
	 * @param client the client
	 * @param world  the passed tile
	 * @return coordinate if the tile is in the current scene, otherwise null
=======
	private final int x, y;

	/**
	 * Returns a LocalPoint of the center of the passed tile
	 *
	 * @return LocalPoint if in scene, otherwise null
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	 */
	@Nullable
	public static LocalPoint fromWorld(Client client, WorldPoint world)
	{
		if (client.getPlane() != world.getPlane())
		{
			return null;
		}
		return fromWorld(client, world.getX(), world.getY());
	}

	/**
<<<<<<< HEAD
	 * Gets the local coordinate at the center of the passed tile.
	 *
	 * @param client the client
	 * @param x      x-axis coordinate of the tile
	 * @param y      y-axis coordinate of the tile
	 * @return coordinate if the tile is in the current scene, otherwise null
=======
	 * Returns a LocalPoint of the center of the passed tile
	 *
	 * @return LocalPoint if in scene, otherwise null
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	 */
	public static LocalPoint fromWorld(Client client, int x, int y)
	{
		if (!WorldPoint.isInScene(client, x, y))
		{
			return null;
		}

		int baseX = client.getBaseX();
		int baseY = client.getBaseY();

		return fromRegion(x - baseX, y - baseY);
	}

	/**
<<<<<<< HEAD
	 * Gets the distance between this point and another.
	 *
	 * @param other other point
	 * @return the distance
=======
	 * Find the distance from this point to another point
	 *
	 * @param other
	 * @return
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	 */
	public int distanceTo(LocalPoint other)
	{
		return (int) Math.hypot(getX() - other.getX(), getY() - other.getY());
	}

	/**
<<<<<<< HEAD
	 * Gets the coordinate at the center of the passed tile.
	 * <p>
	 * The coordinate returned by this method is the true tile location,
	 * in LocalPoint units, relative to tile (0, 0).
	 * <p>
	 * e.g. If the local player is standing on tile 3170, the method returns
	 * 405823, or 3170 * 128 + 64.
	 *
	 * @param x      x-axis coordinate of the tile
	 * @param y      y-axis coordinate of the tile
	 * @return true coordinate of the tile
=======
	 * Returns a LocalPoint of the center of the passed tile
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	 */
	public static LocalPoint fromRegion(int x, int y)
	{
		return new LocalPoint(
			(x << Perspective.LOCAL_COORD_BITS) + (1 << Perspective.LOCAL_COORD_BITS - 1) - 1,
			(y << Perspective.LOCAL_COORD_BITS) + (1 << Perspective.LOCAL_COORD_BITS - 1) - 1
		);
	}

	/**
<<<<<<< HEAD
	 * Gets the x-axis coordinate in scene space (tiles).
	 *
	 * @return x-axis coordinate
=======
	 * Returns the X coordinate in Scene space (tiles)
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	 */
	public int getRegionX()
	{
		return x >>> Perspective.LOCAL_COORD_BITS;
	}

<<<<<<< HEAD
	/**
	 * Gets the y-axis coordinate in scene space (tiles).
	 *
	 * @return y-axis coordinate
=======

	/**
	 * Returns the Y coordinate in Scene space (tiles)
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	 */
	public int getRegionY()
	{
		return y >>> Perspective.LOCAL_COORD_BITS;
	}
}
