import pygame

from board import Board

pygame.init()


board = Board()
turns = 0

while True:
    if turns == 0:
        board.starting_board()
    else:
        pass
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            quit()

        pygame.display.update()
