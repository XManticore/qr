/*
 * AverySquareSticker.java
 * Copyright 2012 Kareem Khazem
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package layout;
public class AverySquareSticker extends PageLayout{
  @Override public int lmargin(){
    return 2370;
  }
  @Override public int rmargin(){
    return 2370;
  }
  @Override public int tmargin(){
    return 2780;
  }
  @Override public int bmargin(){
    return 600;
  }
  @Override public int stickerHeight(){
    return 5080;
  }
  @Override public int stickerWidth(){
    return 5080;
  }
  @Override public int hGap(){
    return 510;
  }
  @Override public int vGap(){
    return 1270;
  }
  @Override public int rows(){
    return 4;
  }
  @Override public int columns(){
    return 3;
  }
}
