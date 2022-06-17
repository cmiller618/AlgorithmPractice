import pygame


class Piece:
    def __init__(self):
        pass

    def update_position(self, piece_img, screen, x, y):
        return screen.blit(piece_img, (x, y))


