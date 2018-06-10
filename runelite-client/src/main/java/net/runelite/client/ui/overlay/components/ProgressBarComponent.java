/*
 * Copyright (c) 2018, Cameron <moberg@tuta.io>
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
package net.runelite.client.ui.overlay.components;

<<<<<<< HEAD
=======
import com.google.common.base.Strings;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.text.DecimalFormat;
<<<<<<< HEAD
import lombok.Setter;

@Setter
public class ProgressBarComponent implements LayoutableRenderableEntity
{
	public enum LabelDisplayMode
	{
		PERCENTAGE,
		FULL
	}

	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.0");
	private static final DecimalFormat DECIMAL_FORMAT_ABS = new DecimalFormat("#0");
	private long minimum;
	private long maximum = 100;
	private double value;
	private LabelDisplayMode labelDisplayMode = LabelDisplayMode.PERCENTAGE;
	private Color foregroundColor = new Color(82, 161, 82);
	private Color backgroundColor = new Color(255, 255, 255, 127);
	private Color fontColor = Color.WHITE;
	private Dimension preferredSize = new Dimension(ComponentConstants.STANDARD_WIDTH, 16);

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final FontMetrics metrics = graphics.getFontMetrics();

		final int barX = 0;
		final int barY = -metrics.getHeight();

		final long span = maximum - minimum;
		final double currentValue = value - minimum;
		final double pc = currentValue / span;
		final String textToWrite;

		switch (labelDisplayMode)
		{
			case PERCENTAGE:
				textToWrite = DECIMAL_FORMAT.format(pc * 100d) + "%";
				break;
			default:
				textToWrite = DECIMAL_FORMAT_ABS.format(Math.floor(currentValue)) + "/" + maximum;
		}

		final int width = preferredSize.width;
		final int height = Math.max(preferredSize.height, 16);
		final int progressTextX = barX + (width - metrics.stringWidth(textToWrite)) / 2;
		final int progressTextY = barY + ((height - metrics.getHeight()) / 2) + metrics.getHeight();
		final int progressFill = (int) (width * pc);
=======
import lombok.Getter;
import lombok.Setter;

public class ProgressBarComponent
{
	@Setter
	private String text;

	@Setter
	private double progress;

	@Setter
	private Point position = new Point();

	@Setter
	private Color foregroundColor = new Color(82, 161, 82);

	@Setter
	private Color backgroundColor = new Color(255, 255, 255, 127);

	@Setter
	private Color fontColor = Color.WHITE;

	@Getter
	@Setter
	private int width = 140;

	@Getter
	@Setter
	private int height = 16;

	public Dimension render(Graphics2D graphics)
	{
		FontMetrics metrics = graphics.getFontMetrics();

		int barX = position.x;
		int barY = position.y;
		String textToWrite;

		if (Strings.isNullOrEmpty(text))
		{
			DecimalFormat df = new DecimalFormat("#0");
			textToWrite = df.format(Math.floor(progress)) + "%";
		}
		else
		{
			textToWrite = text;
		}

		int progressTextX = barX + (width - metrics.stringWidth(textToWrite)) / 2;
		int progressTextY = barY + ((height - metrics.getHeight()) / 2) + metrics.getAscent();

		int progressFill = (int) ((width / 100F) * progress);
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b

		//Draw bar
		graphics.setColor(backgroundColor);
		graphics.fillRect(barX, barY, width, height);
		graphics.setColor(foregroundColor);
		graphics.fillRect(barX, barY, progressFill, height);

<<<<<<< HEAD
		final TextComponent textComponent = new TextComponent();
=======
		TextComponent textComponent = new TextComponent();
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		textComponent.setPosition(new Point(progressTextX, progressTextY));
		textComponent.setColor(fontColor);
		textComponent.setText(textToWrite);
		textComponent.render(graphics);

		return new Dimension(width, height);
	}
}
