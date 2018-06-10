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
package net.runelite.http.service.item;

import java.time.Instant;
<<<<<<< HEAD
import lombok.Data;
import net.runelite.http.api.item.Item;
import net.runelite.http.api.item.ItemType;

@Data
=======
import net.runelite.http.api.item.Item;
import net.runelite.http.api.item.ItemType;

>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
public class ItemEntry
{
	private int id;
	private String name;
	private String description;
	private ItemType type;
	private byte[] icon;
	private byte[] icon_large;
	private Instant timestamp;

	public Item toItem()
	{
		Item item = new Item();
		item.setId(id);
		item.setName(name);
		item.setDescription(description);
		item.setType(type);
		return item;
	}
<<<<<<< HEAD
=======

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public ItemType getType()
	{
		return type;
	}

	public void setType(ItemType type)
	{
		this.type = type;
	}

	public byte[] getIcon()
	{
		return icon;
	}

	public void setIcon(byte[] icon)
	{
		this.icon = icon;
	}

	public byte[] getIcon_large()
	{
		return icon_large;
	}

	public void setIcon_large(byte[] icon_large)
	{
		this.icon_large = icon_large;
	}

	public Instant getTimestamp()
	{
		return timestamp;
	}

	public void setTimestamp(Instant timestamp)
	{
		this.timestamp = timestamp;
	}
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
}
