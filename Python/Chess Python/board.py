import pygame

from bishop import Bishop
from king import King
from knight import Knight
from pawn import Pawn
from queen import Queen
from rook import Rook

SCREEN_WIDTH = 800
SCREEN_HEIGHT = 800
NUMBER_OF_CELLS = 8


class Board:

    def __init__(self):
        pass

    def starting_board(self):
        screen = pygame.display.set_mode((SCREEN_WIDTH, SCREEN_HEIGHT))
        pygame.display.set_caption("Chess")

        chessboard = pygame.image.load("images/chessboard.png")
        chessboard = pygame.transform.scale(chessboard, (SCREEN_WIDTH, SCREEN_HEIGHT))

        screen.fill((255, 255, 255))
        screen.blit(chessboard, (0, 0))
        black_rook = pygame.image.load("images/Black_Rook.png")
        black_knight = pygame.image.load("images/Black_Knight.png")
        black_bishop = pygame.image.load("images/Black_Bishop.png")
        black_queen = pygame.image.load("images/Black_Queen.png")
        black_king = pygame.image.load("images/Black_King.png")
        black_pawn = pygame.image.load("images/Black_Pawn.png")
        white_rook = pygame.image.load("images/White_Rook.png")
        white_knight = pygame.image.load("images/White_Knight.png")
        white_bishop = pygame.image.load("images/White_Bishop.png")
        white_queen = pygame.image.load("images/White_Queen.png")
        white_king = pygame.image.load("images/White_King.png")
        white_pawn = pygame.image.load("images/White_Pawn.png")

        black_rook1 = Rook()
        black_rook1.update_position(black_rook, screen, 20, 20)
        black_rook2 = Rook()
        black_rook2.update_position(black_rook, screen, 720, 20)

        black_knight1 = Knight()
        black_knight1.update_position(black_knight, screen, 120, 20)
        black_knight2 = Knight()
        black_knight2.update_position(black_knight, screen, 620, 20)

        black_bishop1 = Bishop()
        black_bishop1.update_position(black_bishop, screen, 220, 20)
        black_bishop2 = Bishop()
        black_bishop2.update_position(black_bishop, screen, 520, 20)

        black_queen1 = Queen()
        black_queen1.update_position(black_queen, screen, 320, 20)

        black_king1 = King()
        black_king1.update_position(black_king, screen, 420, 20)

        black_pawn1 = Pawn()
        black_pawn1.update_position(black_pawn, screen, 20, 120)
        black_pawn2 = Pawn()
        black_pawn2.update_position(black_pawn, screen, 120, 120)
        black_pawn3 = Pawn()
        black_pawn3.update_position(black_pawn, screen, 220, 120)
        black_pawn4 = Pawn()
        black_pawn4.update_position(black_pawn, screen, 320, 120)
        black_pawn5 = Pawn()
        black_pawn5.update_position(black_pawn, screen, 420, 120)
        black_pawn6 = Pawn()
        black_pawn6.update_position(black_pawn, screen, 520, 120)
        black_pawn7 = Pawn()
        black_pawn7.update_position(black_pawn, screen, 620, 120)
        black_pawn8 = Pawn()
        black_pawn8.update_position(black_pawn, screen, 720, 120)

        white_rook1 = Rook()
        white_rook1.update_position(white_rook, screen, 20, 720)
        white_rook2 = Rook()
        white_rook2.update_position(white_rook, screen, 720, 720)

        white_knight1 = Knight()
        white_knight1.update_position(white_knight, screen, 120, 720)
        white_knight2 = Knight()
        white_knight2.update_position(white_knight, screen, 620, 720)

        white_bishop1 = Bishop()
        white_bishop1.update_position(white_bishop, screen, 520, 720)
        white_bishop2 = Bishop()
        white_bishop2.update_position(white_bishop, screen, 220, 720)

        white_queen1 = Queen()
        white_queen1.update_position(white_queen, screen, 420, 720)

        white_king1 = King()
        white_king1.update_position(white_king, screen, 320, 720)

        white_pawn1 = Pawn()
        white_pawn1.update_position(white_pawn, screen, 20, 620)
        white_pawn2 = Pawn()
        white_pawn2.update_position(white_pawn, screen, 120, 620)
        white_pawn3 = Pawn()
        white_pawn3.update_position(white_pawn, screen, 220, 620)
        white_pawn4 = Pawn()
        white_pawn4.update_position(white_pawn, screen, 320, 620)
        white_pawn5 = Pawn()
        white_pawn5.update_position(white_pawn, screen, 420, 620)
        white_pawn6 = Pawn()
        white_pawn6.update_position(white_pawn, screen, 520, 620)
        white_pawn7 = Pawn()
        white_pawn7.update_position(white_pawn, screen, 620, 620)
        white_pawn8 = Pawn()
        white_pawn8.update_position(white_pawn, screen, 720, 620)
