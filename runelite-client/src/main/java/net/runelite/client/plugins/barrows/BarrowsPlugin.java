/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.barrows;

import com.google.common.collect.Sets;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
<<<<<<< HEAD
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import static net.runelite.api.ItemID.COINS_995;
=======
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
import net.runelite.api.ObjectID;
import net.runelite.api.WallObject;
import net.runelite.api.events.GameObjectChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.WallObjectChanged;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
<<<<<<< HEAD
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.StackFormatter;
import net.runelite.http.api.item.ItemPrice;
=======
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b

@PluginDescriptor(
	name = "Barrows Brothers"
)
<<<<<<< HEAD
@Slf4j
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
public class BarrowsPlugin extends Plugin
{
	@Getter(AccessLevel.PACKAGE)
	private static final Set<Integer> BARROWS_WALLS = Sets.newHashSet
	(
		ObjectID.DOOR_20678, ObjectID.NULL_20681, ObjectID.NULL_20682, ObjectID.NULL_20683, ObjectID.NULL_20684, ObjectID.NULL_20685, ObjectID.NULL_20686, ObjectID.NULL_20687,
		ObjectID.NULL_20688, ObjectID.NULL_20689, ObjectID.NULL_20690, ObjectID.NULL_20691, ObjectID.NULL_20692, ObjectID.NULL_20693, ObjectID.NULL_20694, ObjectID.NULL_20695,
		ObjectID.NULL_20696, ObjectID.DOOR_20697, ObjectID.NULL_20700, ObjectID.NULL_20701, ObjectID.NULL_20702, ObjectID.NULL_20703, ObjectID.NULL_20704, ObjectID.NULL_20705,
		ObjectID.NULL_20706, ObjectID.NULL_20707, ObjectID.NULL_20708, ObjectID.NULL_20709, ObjectID.NULL_20710, ObjectID.NULL_20711, ObjectID.NULL_20712, ObjectID.NULL_20713,
		ObjectID.NULL_20714, ObjectID.NULL_20715, ObjectID.NULL_20728, ObjectID.NULL_20730
	);

	private static final Set<Integer> BARROWS_LADDERS = Sets.newHashSet(ObjectID.NULL_20675, ObjectID.NULL_20676, ObjectID.NULL_20677);

	@Getter(AccessLevel.PACKAGE)
	private final Set<WallObject> walls = new HashSet<>();
	@Getter(AccessLevel.PACKAGE)
	private final Set<GameObject> ladders = new HashSet<>();
	@Inject
	private BarrowsOverlay barrowsOverlay;

	@Inject
	private BarrowsBrotherSlainOverlay brotherOverlay;

	@Provides
	BarrowsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BarrowsConfig.class);
	}

	@Override
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(barrowsOverlay, brotherOverlay);
	}

<<<<<<< HEAD
	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private BarrowsConfig config;

	private long chestPrice;

=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	@Override
	protected void shutDown()
	{
		walls.clear();
		ladders.clear();
	}

	@Subscribe
<<<<<<< HEAD
	public void onWallObjectSpawned(WallObjectSpawned event)
=======
	public void onWallObjectSpanwed(WallObjectSpawned event)
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	{
		WallObject wallObject = event.getWallObject();
		if (BARROWS_WALLS.contains(wallObject.getId()))
		{
			walls.add(wallObject);
		}
	}

	@Subscribe
	public void onWallObjectChanged(WallObjectChanged event)
	{
		WallObject previous = event.getPrevious();
		WallObject wallObject = event.getWallObject();

		walls.remove(previous);
		if (BARROWS_WALLS.contains(wallObject.getId()))
		{
			walls.add(wallObject);
		}
	}

	@Subscribe
	public void onWallObjectDespawned(WallObjectDespawned event)
	{
		WallObject wallObject = event.getWallObject();
		walls.remove(wallObject);
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		GameObject gameObject = event.getGameObject();
		if (BARROWS_LADDERS.contains(gameObject.getId()))
		{
			ladders.add(gameObject);
		}
	}

	@Subscribe
	public void onGameObjectChanged(GameObjectChanged event)
	{
		GameObject previous = event.getPrevious();
		GameObject gameObject = event.getGameObject();

		ladders.remove(previous);
		if (BARROWS_LADDERS.contains(gameObject.getId()))
		{
			ladders.add(gameObject);
		}
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned event)
	{
		GameObject gameObject = event.getGameObject();
		ladders.remove(gameObject);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			// on region changes the tiles get set to null
			walls.clear();
			ladders.clear();
		}
	}
<<<<<<< HEAD

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == WidgetID.BARROWS_REWARD_GROUP_ID && config.showChestValue())
		{
			ItemContainer barrowsRewardContainer = client.getItemContainer(InventoryID.BARROWS_REWARD);
			Item[] items = barrowsRewardContainer.getItems();
			chestPrice = 0;

			for (Item item : items)
			{
				if (item.getId() == COINS_995)
				{
					chestPrice += item.getQuantity();
				}
			}

			CompletableFuture<ItemPrice[]> future = itemManager.getItemPriceBatch(
				Arrays.stream(items).map(Item::getId).collect(Collectors.toList()));
			future.whenComplete((ItemPrice[] itemPrices, Throwable ex) ->
			{
				if (ex != null)
				{
					log.debug("Error looking up item prices", ex);
					return;
				}

				if (itemPrices == null)
				{
					log.debug("Error looking up item prices");
					return;
				}

				log.debug("Price lookup is complete. {} prices.", itemPrices.length);

				try
				{
					for (Item item : items)
					{
						ItemPrice cachedItemPrice = itemManager.getCachedItemPrice(item.getId());
						if (cachedItemPrice == null)
						{
							continue;
						}

						long itemStack = (long) cachedItemPrice.getPrice() * (long) item.getQuantity();
						chestPrice += itemStack;
					}

					final ChatMessageBuilder message = new ChatMessageBuilder()
						.append(ChatColorType.HIGHLIGHT)
						.append("Your chest is worth around ")
						.append(StackFormatter.formatNumber(chestPrice))
						.append(" coins.")
						.append(ChatColorType.NORMAL);

					chatMessageManager.queue(QueuedMessage.builder()
						.type(ChatMessageType.EXAMINE_ITEM)
						.runeLiteFormattedMessage(message.build())
						.build());
				}
				catch (Exception ex2)
				{
					log.warn("error calculating price", ex2);
				}
			});
		}
	}
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
}
