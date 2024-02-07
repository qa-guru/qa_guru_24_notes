package guru.qa.view;

import guru.qa.service.Session;

public class UiComponents implements UiComponent {

  private final UiComponent[] uiComponents;

  public UiComponents(UiComponent... uiComponents) {
    this.uiComponents = uiComponents;
  }

  @Override
  public Session render(Session session) {
    Session initSession = session;
    for (UiComponent uiComponent : uiComponents) {
      initSession = uiComponent.render(initSession);
    }
    return initSession;
  }
}
