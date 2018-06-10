/*
 * Copyright (c) 2017, Tomas Slusny <slusnucky@gmail.com>
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
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;

public class PanelComponent implements LayoutableRenderableEntity
{
	public enum Orientation
	{
		HORIZONTAL,
		VERTICAL;
	}

	@Setter
	private Color backgroundColor = ComponentConstants.STANDARD_BACKGROUND_COLOR;

	@Setter
	private Dimension preferredSize = new Dimension(ComponentConstants.STANDARD_WIDTH, 0);

	@Getter
	private List<LayoutableRenderableEntity> children = new ArrayList<>();

	@Setter
	private Orientation orientation = Orientation.VERTICAL;

	@Setter
	private Rectangle border = new Rectangle(
		ComponentConstants.STANDARD_BORDER,
		ComponentConstants.STANDARD_BORDER,
		ComponentConstants.STANDARD_BORDER,
		ComponentConstants.STANDARD_BORDER);

	@Setter
	private Point gap = new Point(0, 0);

	private final Dimension childDimensions = new Dimension();
=======
import java.util.ListIterator;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.runelite.client.ui.overlay.RenderableEntity;

public class PanelComponent implements RenderableEntity
{
	private static final int TOP_BORDER = 4;
	private static final int LEFT_BORDER = 4;
	private static final int RIGHT_BORDER = 4;
	private static final int BOTTOM_BORDER = 4;
	private static final int SEPARATOR = 1;

	@Data
	@AllArgsConstructor
	public static class Line
	{
		private boolean wrapWords;
		private String left;
		private Color leftColor = Color.WHITE;
		private String right = "";
		private Color rightColor = Color.WHITE;

		public Line(String left)
		{
			this.left = left;
		}

		public Line(boolean wrapWords, String left)
		{
			this.wrapWords = wrapWords;
			this.left = left;
		}

		public Line(String left, Color leftColor)
		{
			this.left = left;
			this.leftColor = leftColor;
		}

		public Line(boolean wrapWords, String left, Color leftColor)
		{
			this.wrapWords = wrapWords;
			this.left = left;
			this.leftColor = leftColor;
		}

		public Line(String left, String right)
		{
			this.left = left;
			this.right = right;
		}

		public Line(boolean wrapWords, String left, String right)
		{
			this.wrapWords = wrapWords;
			this.left = left;
			this.right = right;
		}

		public Line(String left, Color leftColor, String right, Color rightColor)
		{
			this.left = left;
			this.leftColor = leftColor;
			this.right = right;
			this.rightColor = rightColor;
		}
	}

	@Setter
	private String title;

	@Setter
	private Color titleColor = Color.WHITE;

	@Setter
	private Color backgroundColor = BackgroundComponent.DEFAULT_BACKGROUND_COLOR;

	@Setter
	private Point position = new Point();

	@Getter
	private List<Line> lines = new ArrayList<>();

	@Setter
	private ProgressBarComponent progressBar;

	@Setter
	private int width = 129;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b

	@Override
	public Dimension render(Graphics2D graphics)
	{
<<<<<<< HEAD
		if (children.isEmpty())
=======
		final FontMetrics metrics = graphics.getFontMetrics();

		// Do word wrapping
		ListIterator<Line> iterator = lines.listIterator();
		while (iterator.hasNext())
		{
			Line line = iterator.next();

			if (line.wrapWords)
			{
				iterator.remove();

				int maxWidth = width;
				if (line.right.length() > 0)
				{
					maxWidth /= 2;
				}
				maxWidth -= LEFT_BORDER + RIGHT_BORDER;

				List<String> leftSplitLines = lineBreakText(line.getLeft(), maxWidth, metrics);
				List<String> rightSplitLines = lineBreakText(line.getRight(), maxWidth, metrics);

				int lineCount = Math.max(leftSplitLines.size(), rightSplitLines.size());

				for (int i = 0; i < lineCount; i++)
				{
					String left = "";
					String right = "";

					if (i < leftSplitLines.size())
					{
						left = leftSplitLines.get(i);
					}

					if (i < rightSplitLines.size())
					{
						right = rightSplitLines.get(i);
					}

					iterator.add(new Line(false, left, line.getLeftColor(), right, line.getRightColor()));
				}
			}
		}

		final Dimension dimension = new Dimension();
		final int elementNumber = (Strings.isNullOrEmpty(title) ? 0 : 1) + lines.size() + (Objects.isNull(progressBar) ? 0 : 1);
		int height = elementNumber == 0 ? 0 :
			TOP_BORDER + (graphics.getFontMetrics().getHeight() * elementNumber)
				+ SEPARATOR * elementNumber + (Objects.isNull(progressBar) ? 0 : progressBar.getHeight() / 2)
					+ BOTTOM_BORDER;
		dimension.setSize(width, height);

		if (dimension.height == 0)
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		{
			return null;
		}

<<<<<<< HEAD
		final FontMetrics metrics = graphics.getFontMetrics();

		// Render background
		final Dimension dimension = new Dimension(
			border.x + childDimensions.width + border.width,
			border.y + childDimensions.height + border.height);

		final BackgroundComponent backgroundComponent = new BackgroundComponent();
		backgroundComponent.setRectangle(new Rectangle(dimension));
		backgroundComponent.setBackgroundColor(backgroundColor);
		backgroundComponent.render(graphics);

		// Offset children
		final int baseX = border.x;
		final int baseY = border.y + metrics.getHeight();
		int width = 0;
		int height = 0;
		int x = baseX;
		int y = baseY;

		// Create child preferred size
		final Dimension childPreferredSize = new Dimension(
			preferredSize.width - border.x - border.width,
			preferredSize.height - border.y - border.height);

		// Render all children
		for (final LayoutableRenderableEntity child : children)
		{
			child.setPreferredSize(childPreferredSize);
			graphics.translate(x, y);
			final Dimension childDimension = child.render(graphics);
			graphics.translate(-x, -y);

			switch (orientation)
			{
				case VERTICAL:
					height += childDimension.height + gap.y;
					y = baseY + height;
					width = Math.max(width, childDimension.width);
					break;
				case HORIZONTAL:
					width += childDimension.width + gap.x;
					x = baseX + width;
					height = Math.max(height, childDimension.height);
					break;
			}
		}

		// Remove last child gap
		width -= gap.x;
		height -= gap.y;

		// Cache children bounds
		childDimensions.setSize(width, height);

		return dimension;
=======
		// Calculate panel dimensions
		int y = position.y + TOP_BORDER + metrics.getHeight();

		// Render background
		final BackgroundComponent backgroundComponent = new BackgroundComponent();
		backgroundComponent.setBackgroundColor(backgroundColor);
		backgroundComponent.setRectangle(new Rectangle(position.x, position.y, dimension.width, dimension.height));
		backgroundComponent.render(graphics);

		// Render title
		if (!Strings.isNullOrEmpty(title))
		{
			final TextComponent titleComponent = new TextComponent();
			titleComponent.setText(title);
			titleComponent.setColor(titleColor);
			titleComponent.setPosition(new Point(position.x + (width - metrics.stringWidth(title)) / 2, y));
			titleComponent.render(graphics);
			y += metrics.getHeight() + SEPARATOR;
		}

		// Render all lines
		for (final Line line : lines)
		{
			final TextComponent leftLineComponent = new TextComponent();
			leftLineComponent.setPosition(new Point(position.x + LEFT_BORDER, y));
			leftLineComponent.setText(line.getLeft());
			leftLineComponent.setColor(line.getLeftColor());
			leftLineComponent.render(graphics);

			final TextComponent rightLineComponent = new TextComponent();
			rightLineComponent.setPosition(new Point(position.x +  width - RIGHT_BORDER - metrics.stringWidth(TextComponent.textWithoutColTags(line.getRight())), y));
			rightLineComponent.setText(line.getRight());
			rightLineComponent.setColor(line.getRightColor());
			rightLineComponent.render(graphics);
			y += metrics.getHeight() + SEPARATOR;
		}

		//Render progress bar
		if (!Objects.isNull(progressBar))
		{
			progressBar.setWidth(width - LEFT_BORDER - RIGHT_BORDER);
			progressBar.setPosition(new Point(position.x + LEFT_BORDER, y - (metrics.getHeight() / 2)));
			progressBar.render(graphics);
		}

		return dimension;
	}

	private List<String> lineBreakText(String text, int maxWidth, FontMetrics metrics)
	{
		List<String> lines = new ArrayList<>();

		int pos = 0;
		String[] words = text.split(" ");
		String line = "";

		while (pos < words.length)
		{
			String newLine = pos > 0 && !line.isEmpty()
					? line + " " + words[pos]
					: words[pos];
			int width = metrics.stringWidth(newLine);

			if (width >= maxWidth)
			{
				lines.add(line);
				line = "";
			}
			else
			{
				line = newLine;
				pos++;
			}
		}

		lines.add(line);

		return lines;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	}
}
