/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.client.plugins.screenshot;

import com.google.common.annotations.VisibleForTesting;
<<<<<<< HEAD
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
=======
import com.google.common.collect.ImmutableMap;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FontMetrics;
import java.awt.Graphics;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
<<<<<<< HEAD
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Consumer;
=======
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Point;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import static net.runelite.api.widgets.WidgetID.BARROWS_REWARD_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.CLUE_SCROLL_REWARD_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.DIALOG_SPRITE_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.LEVEL_UP_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.QUEST_COMPLETED_GROUP_ID;
import static net.runelite.api.widgets.WidgetID.RAIDS_REWARD_GROUP_ID;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.api.widgets.WidgetInfo.TO_GROUP;
import net.runelite.client.Notifier;
import static net.runelite.client.RuneLite.SCREENSHOT_DIR;
<<<<<<< HEAD
=======
import net.runelite.client.ui.DrawManager;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.screenshot.imgur.ImageUploadRequest;
import net.runelite.client.plugins.screenshot.imgur.ImageUploadResponse;
import net.runelite.client.ui.ClientUI;
<<<<<<< HEAD
import net.runelite.client.ui.DrawManager;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.TitleToolbar;
import net.runelite.client.ui.overlay.Overlay;
=======
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.TitleToolbar;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
import net.runelite.client.util.Text;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@PluginDescriptor(
	name = "Screenshot"
)
@Slf4j
public class ScreenshotPlugin extends Plugin
{
	private static final String IMGUR_CLIENT_ID = "30d71e5f6860809";
	private static final HttpUrl IMGUR_IMAGE_UPLOAD_URL = HttpUrl.parse("https://api.imgur.com/3/image");
	private static final MediaType JSON = MediaType.parse("application/json");

<<<<<<< HEAD
	static final DateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
=======
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("MMM. dd, yyyy", Locale.US);
	static final DateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b

	private static final Pattern NUMBER_PATTERN = Pattern.compile("([0-9]+)");
	private static final Pattern LEVEL_UP_PATTERN = Pattern.compile("Your ([a-zA-Z]+) (?:level is|are)? now (\\d+)\\.");

<<<<<<< HEAD
	private static final ImmutableList<String> PET_MESSAGES = ImmutableList.of("You have a funny feeling like you're being followed",
		"You feel something weird sneaking into your backpack",
		"You have a funny feeling like you would have been followed");

	private static final ImmutableList<String> KILL_MESSAGES = ImmutableList.of("into tiny pieces and sat on them", "you have obliterated",
		"falls before your might", "A humiliating defeat for", "With a crushing blow you", "thinking challenging you",
		"Can anyone defeat you? Certainly", "was no match for you", "You were clearly a better fighter than", "RIP",
		"You have defeated", "What an embarrassing performance by", "was no match for your awesomeness");

=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	private String clueType;
	private Integer clueNumber;

	private Integer barrowsNumber;

	private Integer raidsNumber;

	@Inject
	private ScreenshotConfig config;

	@Inject
<<<<<<< HEAD
	private ScreenshotOverlay screenshotOverlay;

	@Inject
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	private Notifier notifier;

	@Inject
	private Client client;

	@Inject
	private ClientUI clientUi;

	@Inject
	private TitleToolbar titleToolbar;

	@Inject
	private DrawManager drawManager;

	@Inject
	private ScreenshotInput inputListener;

	@Inject
	private ScheduledExecutorService executor;

	@Inject
	private KeyManager keyManager;

	private NavigationButton titleBarButton;

	@Provides
	ScreenshotConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ScreenshotConfig.class);
	}

	@Override
<<<<<<< HEAD
	public Overlay getOverlay()
	{
		return screenshotOverlay;
	}

	@Override
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	protected void startUp() throws Exception
	{
		SCREENSHOT_DIR.mkdirs();
		keyManager.registerKeyListener(inputListener);

		try
		{
			BufferedImage iconImage;
			synchronized (ImageIO.class)
			{
				iconImage = ImageIO.read(ScreenshotPlugin.class.getResourceAsStream("screenshot.png"));
			}

			titleBarButton = NavigationButton.builder()
				.tooltip("Take screenshot")
				.icon(iconImage)
<<<<<<< HEAD
				.onClick(() -> takeScreenshot(TIME_FORMAT.format(new Date())))
=======
				.onClick(() -> takeScreenshot(
					TIME_FORMAT.format(new Date()),
					client.getLocalPlayer() != null))
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
				.popup(ImmutableMap
					.<String, Runnable>builder()
					.put("Open screenshot folder...", () ->
					{
						try
						{
							Desktop.getDesktop().open(SCREENSHOT_DIR);
						}
						catch (IOException ex)
						{
							log.warn("Error opening screenshot dir", ex);

						}
					})
					.build())
				.build();

			titleToolbar.addNavigation(titleBarButton);
		}
		catch (IOException ex)
		{
			log.warn("Error adding screenshot button to titlebar", ex);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		titleToolbar.removeNavigation(titleBarButton);
		keyManager.unregisterKeyListener(inputListener);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SERVER && event.getType() != ChatMessageType.FILTERED)
		{
			return;
		}

		String chatMessage = event.getMessage();

		if (chatMessage.contains("You have completed") && chatMessage.contains("Treasure"))
		{
			Matcher m = NUMBER_PATTERN.matcher(Text.removeTags(chatMessage));
			if (m.find())
			{
				clueNumber = Integer.valueOf(m.group());
				clueType = chatMessage.substring(chatMessage.lastIndexOf(m.group()) + m.group().length() + 1, chatMessage.indexOf("Treasure") - 1);
				return;
			}
		}

		if (chatMessage.startsWith("Your Barrows chest count is"))
		{
			Matcher m = NUMBER_PATTERN.matcher(Text.removeTags(chatMessage));
			if (m.find())
			{
				barrowsNumber = Integer.valueOf(m.group());
				return;
			}
		}

		if (chatMessage.startsWith("Your completed Chambers of Xeric count is:"))
		{
			Matcher m = NUMBER_PATTERN.matcher(Text.removeTags(chatMessage));
			if (m.find())
			{
				raidsNumber = Integer.valueOf(m.group());
				return;
			}
		}
<<<<<<< HEAD

		if (config.screenshotPet() && PET_MESSAGES.stream().anyMatch(chatMessage::contains))
		{
			String fileName = "Pet " + TIME_FORMAT.format(new Date());
			takeScreenshot(fileName);
		}

		if (config.screenshotKills() && KILL_MESSAGES.stream().anyMatch(chatMessage::contains))
		{
			String fileName = "Kill " + TIME_FORMAT.format(new Date());
			takeScreenshot(fileName);
		}
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	}

	@Subscribe
	public void loadWidgets(WidgetLoaded event)
	{
		if (!config.screenshotKingdom())
		{
			return;
		}
		if (event.getGroupId() == WidgetID.KINGDOM_GROUP_ID)
		{
			String fileName = "Kingdom " + LocalDate.now();
<<<<<<< HEAD
			takeScreenshot(fileName);
=======
			takeScreenshot(fileName, config.displayDate());
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		}
	}

	@Subscribe
	public void hideWidgets(WidgetHiddenChanged event)
	{
		Widget widget = event.getWidget();

		if (widget.isHidden())
		{
			return;
		}

		switch (TO_GROUP(widget.getId()))
		{
			case LEVEL_UP_GROUP_ID:
<<<<<<< HEAD
			case DIALOG_SPRITE_GROUP_ID:
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
				if (!config.screenshotLevels())
				{
					return;
				}
				break;
			case QUEST_COMPLETED_GROUP_ID:
			case CLUE_SCROLL_REWARD_GROUP_ID:
			case BARROWS_REWARD_GROUP_ID:
			case RAIDS_REWARD_GROUP_ID:
				if (!config.screenshotRewards())
				{
					return;
				}
				break;
		}

		String fileName;

		switch (TO_GROUP(widget.getId()))
		{
			case LEVEL_UP_GROUP_ID:
			{
				fileName = parseLevelUpWidget(WidgetInfo.LEVEL_UP_LEVEL);
				break;
			}
			case DIALOG_SPRITE_GROUP_ID:
			{
				fileName = parseLevelUpWidget(WidgetInfo.DIALOG_SPRITE_TEXT);
				break;
			}
			case QUEST_COMPLETED_GROUP_ID:
			{
				Widget textChild = client.getWidget(WidgetInfo.QUEST_COMPLETED_NAME_TEXT);

				if (textChild == null)
				{
					return;
				}

				// "You have completed The Corsair Curse!"
				String text = textChild.getText();

				fileName = text.substring(19, text.length() - 1);
				break;
			}
			case CLUE_SCROLL_REWARD_GROUP_ID:
			{
				if (clueType == null || clueNumber == null)
				{
					return;
				}

				fileName = Character.toUpperCase(clueType.charAt(0)) + clueType.substring(1) + "(" + clueNumber + ")";
				clueType = null;
				clueNumber = null;
				break;
			}
			case BARROWS_REWARD_GROUP_ID:
			{
				if (barrowsNumber == null)
				{
					return;
				}

				fileName = "Barrows(" + barrowsNumber + ")";
				barrowsNumber = null;
				break;
			}
			case RAIDS_REWARD_GROUP_ID:
			{
				if (raidsNumber == null)
				{
					return;
				}

				fileName = "Raids(" + raidsNumber + ")";
				raidsNumber = null;
				break;
			}
			default:
				return;
		}

		if (fileName == null)
		{
			return;
		}

<<<<<<< HEAD
		takeScreenshot(fileName);
=======
		takeScreenshot(fileName, config.displayDate());
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	}

	/**
	 * Receives a WidgetInfo pointing to the middle widget of the level-up dialog,
	 * and parses it into a shortened string for filename usage.
	 *
	 * @param levelUpLevel WidgetInfo pointing to the required text widget,
	 *                     with the format "Your Skill (level is/are) now 99."
	 * @return Shortened string in the format "Skill(99)"
	 */
	String parseLevelUpWidget(WidgetInfo levelUpLevel)
	{
		Widget levelChild = client.getWidget(levelUpLevel);
		if (levelChild == null)
		{
			return null;
		}

		Matcher m = LEVEL_UP_PATTERN.matcher(levelChild.getText());
		if (!m.matches())
		{
			return null;
		}

		String skillName = m.group(1);
		String skillLevel = m.group(2);
		return skillName + "(" + skillLevel + ")";
	}

	/**
	 * Saves a screenshot of the client window to the screenshot folder as a PNG,
	 * and optionally uploads it to an image-hosting service.
	 *
	 * @param fileName    Filename to use, without file extension.
<<<<<<< HEAD
	 */
	void takeScreenshot(String fileName)
=======
	 * @param displayDate Whether to show today's date on the report button as the screenshot is taken.
	 */
	void takeScreenshot(String fileName, boolean displayDate)
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	{
		if (client.getGameState() == GameState.LOGIN_SCREEN)
		{
			// Prevent the screenshot from being captured
			log.info("Login screenshot prevented");
			return;
		}

<<<<<<< HEAD
		Consumer<Image> screenshotConsumer = image ->
		{
			BufferedImage screenshot = config.includeFrame()
				? new BufferedImage(clientUi.getWidth(), clientUi.getHeight(), BufferedImage.TYPE_INT_ARGB)
				: new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
=======
		drawManager.requestNextFrameListener(image ->
		{
			BufferedImage screenshot = config.includeFrame()
				? new BufferedImage(clientUi.getWidth(), clientUi.getHeight(), BufferedImage.TYPE_INT_ARGB)
				: new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b

			Graphics graphics = screenshot.getGraphics();

			int gameOffsetX = 0;
			int gameOffsetY = 0;

			if (config.includeFrame())
			{
				// Draw the client frame onto the screenshot
				clientUi.paint(graphics);

				// Evaluate the position of the game inside the frame
				final Point canvasOffset = clientUi.getCanvasOffset();
				gameOffsetX = canvasOffset.getX();
				gameOffsetY = canvasOffset.getY();
			}

			// Draw the game onto the screenshot
			graphics.drawImage(image, gameOffsetX, gameOffsetY, null);

<<<<<<< HEAD
=======
			if (displayDate)
			{
				try (InputStream reportButton = ScreenshotPlugin.class.getResourceAsStream("report_button.png"))
				{
					BufferedImage reportButtonImage;
					synchronized (ImageIO.class)
					{
						reportButtonImage = ImageIO.read(reportButton);
					}

					int x = gameOffsetX + 403;
					int y = gameOffsetY + image.getHeight() - reportButtonImage.getHeight() - 1;

					graphics.drawImage(reportButtonImage, x, y, null);

					graphics.setFont(FontManager.getRunescapeSmallFont());
					FontMetrics fontMetrics = graphics.getFontMetrics();

					String date = DATE_FORMAT.format(new Date());
					int dateWidth = fontMetrics.stringWidth(date);
					int dateHeight = fontMetrics.getHeight();

					int textX = x + reportButtonImage.getWidth() / 2 - dateWidth / 2;
					int textY = y + reportButtonImage.getHeight() / 2 + dateHeight / 2;

					graphics.setColor(Color.BLACK);
					graphics.drawString(date, textX + 1, textY + 1);

					graphics.setColor(Color.WHITE);
					graphics.drawString(date, textX, textY);
				}
				catch (Exception ex)
				{
					log.warn("error displaying date on screenshot", ex);
				}
			}

>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
			File playerFolder;
			if (client.getLocalPlayer() != null && client.getLocalPlayer().getName() != null)
			{
				playerFolder = new File(SCREENSHOT_DIR, client.getLocalPlayer().getName());
			}
			else
			{
				playerFolder = SCREENSHOT_DIR;
			}

			playerFolder.mkdirs();

			executor.execute(() ->
			{
				try
				{
					File screenshotFile = new File(playerFolder, fileName + ".png");

					ImageIO.write(screenshot, "PNG", screenshotFile);

					if (config.uploadScreenshot())
					{
						uploadScreenshot(screenshotFile);
					}
					else if (config.notifyWhenTaken())
					{
						notifier.notify("A screenshot was saved to " + screenshotFile, TrayIcon.MessageType.INFO);
					}
				}
				catch (IOException ex)
				{
					log.warn("error writing screenshot", ex);
				}
			});
<<<<<<< HEAD
		};

		if (config.displayDate())
		{
			screenshotOverlay.queueForTimestamp(screenshotConsumer);
		}
		else
		{
			drawManager.requestNextFrameListener(screenshotConsumer);
		}
=======
		});
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	}

	/**
	 * Uploads a screenshot to the Imgur image-hosting service,
	 * and copies the image link to the clipboard.
	 *
	 * @param screenshotFile Image file to upload.
	 * @throws IOException Thrown if the file cannot be read.
	 */
	private void uploadScreenshot(File screenshotFile) throws IOException
	{
		String json = RuneLiteAPI.GSON.toJson(new ImageUploadRequest(screenshotFile));

		Request request = new Request.Builder()
			.url(IMGUR_IMAGE_UPLOAD_URL)
			.addHeader("Authorization", "Client-ID " + IMGUR_CLIENT_ID)
			.post(RequestBody.create(JSON, json))
			.build();

		RuneLiteAPI.CLIENT.newCall(request).enqueue(new Callback()
		{
			@Override
			public void onFailure(Call call, IOException ex)
			{
				log.warn("error uploading screenshot", ex);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException
			{
				try (InputStream in = response.body().byteStream())
				{
					ImageUploadResponse imageUploadResponse = RuneLiteAPI.GSON
							.fromJson(new InputStreamReader(in), ImageUploadResponse.class);

					if (imageUploadResponse.isSuccess())
					{
						String link = imageUploadResponse.getData().getLink();

						StringSelection selection = new StringSelection(link);
						Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
						clipboard.setContents(selection, selection);

						if (config.notifyWhenTaken())
						{
							notifier.notify("A screenshot was uploaded and inserted into your clipboard!", TrayIcon.MessageType.INFO);
						}
					}
				}
			}
		});
	}

	@VisibleForTesting
	int getClueNumber()
	{
		return clueNumber;
	}

	@VisibleForTesting
	String getClueType()
	{
		return clueType;
	}

	@VisibleForTesting
	int getBarrowsNumber()
	{
		return barrowsNumber;
	}

	@VisibleForTesting
	int getRaidsNumber()
	{
		return raidsNumber;
	}
}
