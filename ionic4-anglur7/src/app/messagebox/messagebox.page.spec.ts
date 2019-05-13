import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MessageboxPage } from './messagebox.page';

describe('MessageboxPage', () => {
  let component: MessageboxPage;
  let fixture: ComponentFixture<MessageboxPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MessageboxPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MessageboxPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
