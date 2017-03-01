//
//  m9-direct-visibility.cpp
//  spoj
//
//  Created by Jose Andres Gonzalez Barrameda on 12-03-04.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//
#include <string>
#include <iostream>
#include <list>

using namespace std;

struct VertexRelax {
    int vertex;
    double d;
    int previousVertex;
};

class Graph {

public:
    int *w;
    int rows;
    int columns;
    // base station 1 coordinates
    int *bs1 = new int[2];
    // base station 2 coordinates
    int *bs2 = new int[2];

    ~Graph() {
        if (w) {
            delete (w);
            w = 0;
        }
    }

    // throws 0 when there are no rows
    void ReadGraph(void) {
        int row;
        int column;

        cin >> rows;
        cin >> columns;

        if (rows == 0) {
            throw 0;
        }

        w = new int[rows * columns];

        int height;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                cin >> height;
                SetHeight(row, col, height);
            }
        }

        cin >> bs1[0];
        cin >> bs1[1];
        cin >> bs2[0];
        cin >> bs2[1];
    }

    int GetHeight(int row, int col) {
        return w[row * columns + col];
    }

    void SetHeight(int row, int col, double height) {
        w[row * columns + col] = height;
    }

    std::string ToString() {
        std::string result;
        result.append("rows " + std::to_string(rows));
        result.append(", columns " + std::to_string(columns));
        result.append("\n");
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                result.append(std::to_string(GetHeight(row, col)) + " ");
            }
            result.append("\n");
        }
        result.append("bs1 " + std::to_string(bs1[0]) + ", " + std::to_string(bs1[1]));
        result.append("\n");
        result.append("bs2 " + std::to_string(bs2[0]) + ", " + std::to_string(bs2[1]));
        result.append("\n");
        return result;
    }
};

static double lowerBound = 0;
//
//class ShortestPathFinder {
//
//private:
//    Graph *g;
//    VertexRelax **data;
//
//    void Relax(VertexRelax *source, VertexRelax *destination, double w) {
//        if (destination->d < source->d * w) {
//            destination->d = source->d * w;
//            destination->previousVertex = source->vertex;
//        }
//    }
//
//    void InitializeData() {
//        data = new VertexRelax **(g->rows * sizeof(VertexRelax *));
//
//        for (int i = 0; i < g->rows; i++) {
//            VertexRelax *vr = new VertexRelax();
//
//            vr->vertex = i;
//            vr->d = (i == source) ? 1 : lowerBound;
//            vr->previousVertex = -1;
//
//            data[i] = vr;
//        }
//    }
//
//    VertexRelax *ExtractMaximum(list<VertexRelax *> *toVisit) {
//        VertexRelax *maximum = toVisit->front();
//
//        for (list<VertexRelax *>::iterator it = toVisit->begin(); it != toVisit->end(); ++it) {
//            if ((*it)->d > maximum->d) {
//                maximum = *it;
//            }
//        }
//
//        toVisit->remove(maximum);
//
//        return maximum;
//    }
//
//
//public:
//    double shortestPathWeight;
//    int source, destination;
//
//    void FindShortestPath(Graph *g, int source, int destination) {
//        this->g = g;
//        this->source = source;
//        this->destination = destination;
//
//        InitializeData();
//
//        // initialize to visit
//        list<VertexRelax *> toVisit;
//        for (int i = 0; i < g->rows; i++) {
//            toVisit.push_back(data[i]);
//        }
//
//        while (toVisit.size() != 0) {
//            VertexRelax *maximum = ExtractMaximum(&toVisit);
//
//            for (int i = 0; i < g->rows; i++) {
//                if (g->GetHeight(i, maximum->vertex)) {
//                    this->Relax(maximum, data[i], g->GetHeight(maximum->vertex, data[i]->vertex));
//                }
//            }
//        }
//
//        shortestPathWeight = data[destination]->d;
//    }
//
//    ~ShortestPathFinder() {
//        delete(data);
//    }
//};


int main() {
    list<double> results;
    try {
        Graph g;
        g.ReadGraph();
        cout << g.ToString();
//        while (true) {
//            Graph g;
//            g.ReadGraph();
//            cout << g.ToString();
//            //ShortestPathFinder spf;
//            //spf.FindShortestPath(&g, 0, g.rows - 1);
//            //results.push_back(spf.shortestPathWeight);
//        }
    }
    catch (int i) {
    }

//    bool firstSolution = true;
//    for (list<double>::iterator it = results.begin(); it != results.end(); ++it) {
//        if (!firstSolution) {
//            cout << endl;
//        }
//        firstSolution = false;
//
//        printf("%2.6f percent", (*it) * 100);
//    }
}