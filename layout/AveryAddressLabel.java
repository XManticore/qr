/*
 * AveryAddressLabel.java
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
public class AveryAddressLabel extends PageLayout{
  @Override public int lmargin(){
    return 455;
  }
  @Override public int rmargin(){
    return 455;
  }
  @Override public int tmargin(){
    return 1650;
  }
  @Override public int bmargin(){
    return 600;
  }
  @Override public int stickerHeight(){
    return 3400;
  }
  @Override public int stickerWidth(){
    return 9910;
  }
  @Override public int hGap(){
    return 340;
  }
  @Override public int vGap(){
    return 0;
  }
  @Override public int rows(){
    return 16;
  }
  @Override public int columns(){
    return 2;
  }
}
