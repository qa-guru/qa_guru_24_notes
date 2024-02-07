package guru.qa.view;

import guru.qa.service.Session;

public interface UiComponent {

  Session render(Session session);

  class MockUiComponent implements UiComponent {

    @Override
    public Session render(Session session) {
      System.out.println("I`m just stupid MOCK UI component (");
      return session;
    }
  }
}
