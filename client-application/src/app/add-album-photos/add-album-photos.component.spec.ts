import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAlbumPhotosComponent } from './add-album-photos.component';

describe('AddAlbumPhotosComponent', () => {
  let component: AddAlbumPhotosComponent;
  let fixture: ComponentFixture<AddAlbumPhotosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddAlbumPhotosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddAlbumPhotosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
