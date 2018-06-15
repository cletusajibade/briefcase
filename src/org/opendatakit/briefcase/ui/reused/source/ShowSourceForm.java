/*
 * Copyright (C) 2018 Nafundi
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.opendatakit.briefcase.ui.reused.source;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("checkstyle:MethodName")
public class ShowSourceForm extends JComponent {
  private final String action;
  public JPanel container;
  private JLabel sourceLabel;
  private JButton resetButton;
  private JLabel actionLabel;
  private List<Runnable> onResetCallbacks = new ArrayList<>();

  private ShowSourceForm(String action) {
    $$$setupUI$$$();
    this.action = action;

    resetButton.addActionListener(__ -> onResetCallbacks.forEach(Runnable::run));
  }

  static ShowSourceForm empty(String action) {
    return new ShowSourceForm(action);
  }

  void onReset(Runnable callback) {
    onResetCallbacks.add(callback);
  }

  void showSource(Source source) {
    actionLabel.setText(action + ": " + source.toString());
    sourceLabel.setText(source.getDescription());
  }

  private void createUIComponents() {
    // TODO: place custom component creation code here
  }

  public JComponent getContainer() {
    return container;
  }

  @Override
  public void setEnabled(boolean enabled) {
    super.setEnabled(enabled);
    resetButton.setEnabled(enabled);
  }

  /**
   * Method generated by IntelliJ IDEA GUI Designer
   * >>> IMPORTANT!! <<<
   * DO NOT edit this method OR call it in your code!
   *
   * @noinspection ALL
   */
  private void $$$setupUI$$$() {
    container = new JPanel();
    container.setLayout(new GridBagLayout());
    sourceLabel = new JLabel();
    sourceLabel.setText("Source info");
    GridBagConstraints gbc;
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.weightx = 1.0;
    gbc.anchor = GridBagConstraints.WEST;
    container.add(sourceLabel, gbc);
    actionLabel = new JLabel();
    actionLabel.setText("Pulling data from %s");
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 1.0;
    gbc.anchor = GridBagConstraints.WEST;
    container.add(actionLabel, gbc);
    resetButton = new JButton();
    resetButton.setText("Reset");
    gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 0;
    gbc.gridheight = 2;
    gbc.anchor = GridBagConstraints.EAST;
    container.add(resetButton, gbc);
    final JPanel spacer1 = new JPanel();
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.gridheight = 2;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    container.add(spacer1, gbc);
  }

  /**
   * @noinspection ALL
   */
  public JComponent $$$getRootComponent$$$() {
    return container;
  }
}