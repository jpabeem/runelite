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
package net.runelite.api.widgets;

import java.awt.Rectangle;
import net.runelite.api.Point;

<<<<<<< HEAD
/**
 * An item that is being represented in a {@link Widget}.
 */
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
public class WidgetItem
{
	private final int id;
	private final int quantity;
	private final int index;
	private final Rectangle canvasBounds;

	public WidgetItem(int id, int quantity, int index, Rectangle canvasBounds)
	{
		this.id = id;
		this.quantity = quantity;
		this.index = index;
		this.canvasBounds = canvasBounds;
	}

	@Override
	public String toString()
	{
		return "WidgetItem{" + "id=" + id + ", quantity=" + quantity + ", index=" + index + ", canvasBounds=" + canvasBounds + '}';
	}

<<<<<<< HEAD
	/**
	 * Gets the ID of the item represented.
	 *
	 * @return the items ID
	 * @see net.runelite.api.ItemID
	 */
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	public int getId()
	{
		return id;
	}

<<<<<<< HEAD
	/**
	 * Gets the quantity of the represented item.
	 *
	 * @return the items quantity
	 */
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	public int getQuantity()
	{
		return quantity;
	}

<<<<<<< HEAD
	/**
	 * Gets the index position of this WidgetItem inside its parents
	 * WidgetItem array.
	 *
	 * @return the index in the parent widget
	 * @see Widget#getWidgetItems()
	 */
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	public int getIndex()
	{
		return index;
	}

<<<<<<< HEAD
	/**
	 * Gets the area where the widget is drawn on the canvas.
	 *
	 * @return the occupied area of the widget
	 */
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	public Rectangle getCanvasBounds()
	{
		return canvasBounds;
	}

<<<<<<< HEAD
	/**
	 * Gets the upper-left coordinate of where the widget is being drawn
	 * on the canvas.
	 *
	 * @return the upper-left coordinate of where this widget is drawn
	 */
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	public Point getCanvasLocation()
	{
		return new Point((int) canvasBounds.getX(), (int) canvasBounds.getY());
	}

}
